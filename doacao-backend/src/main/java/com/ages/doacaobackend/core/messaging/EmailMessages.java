package com.ages.doacaobackend.core.messaging;

public abstract class EmailMessages {
    
    public static final String NOTIFY_ADMIN_NEW_INSTITUTION_REQUEST_SUBJECT = "Solicitação de criação de Insituiçao recebida";
    public static final String NOTIFY_INTEREST_IN_DONATION_SUBJECT = "Há alguém interessado em doar!";
    public static final String STATUS_UPDATE_SUBJECT = "Status de Cadastro";
    public static final String NOTIFY_ADMIN_NEW_URGENT_ORDER_SUBJECT = "Solicitação de pedido urgente recebida";

    public static final String NOTIFY_ADMIN_NEW_INSTITUTION_REQUEST_MESSAGE = "Olá,\n\nFoi solicitada a criação de uma nova instituição, por favor entre na plataforma e validade se a mesma deve ser aceita.";
    public static final String NOTIFY_INTEREST_IN_DONATION_MESSAGE = "Olá,\n\n\n%s se interessou em doar %s, referente ao pedido de %s de número %s!\n\nConta-te o doador através do %s";
    public static final String STATUS_UPDATE_MESSAGE = "Olá,\n\nSua instituição está com o status ";
    public static final String NOTIFY_ADMIN_NEW_URGENT_ORDER_MESSAGE = "Olá,\n\nFoi solicitado um novo pedido urgente, por favor entre na plataforma e valide se o mesmo deve ser aceito.\n\nId do pedido: ";

    public static final String NOTIFY_UPDATE_URGENT_ORDER_SUBJECT = "Atualização de status do pedido";

    public static final String NOTIFY_UPDATE_URGENT_ORDER_MESSAGE = "Olá, \n\nSeu pedido urgente foi aceito!\nEle ficará ativo por 30 dias";
    public static final String NOTIFY_UPDATE_URGENT_ORDER_DECLINED_MESSAGE = "Olá, \n\nSeu pedido urgente foi negado!";

    public static final String NOTIFY_ADMIN_NEW_ITEM_SOLICITED_SUBJECT = "Solicitação de um novo item foi recebida";
    public static final String NOTIFY_ADMIN_NEW_ITEM_SOLICITED_MESSAGE = "Olá administrador, um novo item foi solicitado na plataforma!";
    
    public static final String ITEM_STATUS_UPDATE_MESSAGE = "Olá,\n\nSeu item solicitado %s está com o status %s ";
    public static final String ITEM_STATUS_UPDATE_SUBJECT = "Status de Solicitação de novo Item";

    public static final String NOTIFY_ADMIN_NEW_SERVICE_SOLICITED_SUBJECT = "Solicitação de um novo serviço foi recebida";
    public static final String NOTIFY_ADMIN_NEW_SERVICE_SOLICITED_MESSAGE = "Olá administrador, um novo serviço foi solicitado na plataforma!";

    public static final String SERVICE_STATUS_UPDATE_MESSAGE = "Olá,\n\nSeu serviço solicitado %s está com o status %s ";
    public static final String SERVICE_STATUS_UPDATE_SUBJECT = "Status de Solicitação de novo Serviço";
}
