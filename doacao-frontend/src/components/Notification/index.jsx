import { store } from 'react-notifications-component';

/**
 * types disponiveis: 
 * success (default)
 *  danger
 *  info
 *  default
 *  warning
 */
export const showNotification = (
  message = '',
  title = '',
  type = 'success',
  insert = "top",
  container = "top-center",
  animationIn = ["animated", "fadeIn"],
  animationOut = ["animated", "fadeOut"],
  dismiss = {
    duration: 2000,
    onScreen: true,
    pauseOnHover: true,
  }
) => {
  store.addNotification({
    title,
    message,
    type,
    insert,
    container,
    animationIn,
    animationOut,
    dismiss
  });
}
