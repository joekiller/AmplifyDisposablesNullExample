exports.handler = (event) => {
  // Confirm the user
    event.response.autoConfirmUser = true;

    // Return to Amazon Cognito
  return event
};
