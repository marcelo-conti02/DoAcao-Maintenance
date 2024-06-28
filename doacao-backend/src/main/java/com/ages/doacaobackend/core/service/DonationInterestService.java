package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.donation.DonationInterestRequest;
import com.ages.doacaobackend.business.dto.donation.Interest;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_INTEREST_IN_DONATION_MESSAGE;
import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_INTEREST_IN_DONATION_SUBJECT;
import static java.util.Objects.isNull;

@Service
public class DonationInterestService {

    @Autowired
    EmailSender sender;

    @Autowired
    AdminService adminService;

    @Autowired
    ProductOrderDetailsService productOrderDetailsService;

    @Autowired
    ServiceOrderDetailsService serviceOrderDetailsService;

    @Autowired
    InstitutionService institutionService;

    public void notifyInterest(DonationInterestRequest request, boolean isService) throws MalformedEntityException, EntityNotFoundException {
        verifyIfIsCommunicable(request);
        Institution institution = getInstitutionIdFromService(request, isService);
        String message = complementMessage(request, isService);
        sender.sendEmail(
                message,
                NOTIFY_INTEREST_IN_DONATION_SUBJECT,
                institution.getEmail()
        );
        for (AdminDTO adminDto: adminService.getAll()) {
            sender.sendEmail(
                    message,
                    NOTIFY_INTEREST_IN_DONATION_SUBJECT,
                    adminDto.getEmail()
            );
        }
    }

    private String complementMessage(DonationInterestRequest request, boolean isService) {
        return String.format(
                NOTIFY_INTEREST_IN_DONATION_MESSAGE,
                request.getName(),
                getDonationInterests(request.getItemsAndQuantities()),
                isService ? "serviços" : "items",
                request.getOrderId(),
                getCommunicationOptions(request)
            );
    }

    private String getDonationInterests(List<Interest> items) {
        StringBuilder builder = new StringBuilder();
        for (Interest item : items) {
            builder.append(item.getAmount());
            builder.append(" de ");
            builder.append(item.getInterestName());
            builder.append(',');
        }
        String donatedItems = builder.toString();
        return donatedItems.substring(0,donatedItems.length() - 1);
    }

    private void verifyIfIsCommunicable(DonationInterestRequest request) throws MalformedEntityException {
        if (isNull(request.getEmail()) & isNull(request.getPhone())) {
            throw new MalformedEntityException(Collections.singletonList("Impossível comunicar-se com doador."));
        }
    }

    private String getCommunicationOptions(DonationInterestRequest request) {
        if (isNull(request.getEmail())) return "número " + request.getPhone();
        if (isNull(request.getPhone())) return "email " + request.getEmail();
        return "email " + request.getEmail() + " ou do número " + request.getPhone();
    }

    private Institution getInstitutionIdFromService(DonationInterestRequest req, boolean isService) {
        return isService ? serviceOrderDetailsService.getInstitutionFromOrderId(req.getOrderId()) :
                productOrderDetailsService.findInstitutionByOrderId(req.getOrderId());
    }
}
