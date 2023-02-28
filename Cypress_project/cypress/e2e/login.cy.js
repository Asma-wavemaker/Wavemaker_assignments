// login checking for invalid number or email with valid password

describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://amazon.in');
    cy.get('#nav-link-accountList-nav-line-1').click();
    cy.get('#ap_email').click().type(/*enter valid mobile number or email */);
    cy.get('.a-button-inner > #continue').click();
    cy.get('#ap_password').click().type(/* check for invalid password */);
    cy.get('#signInSubmit').click();
  })
})


// login checking for valid number or email with invalid password
describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://amazon.in');
    cy.get('#nav-link-accountList-nav-line-1').click();
    cy.get('#ap_email').click().type(/*check for invalid mobile number or email */);
    cy.get('.a-button-inner > #continue').click();
    cy.get('#ap_password').click().type(/*enter valid password */);
    cy.get('#signInSubmit').click();
  })
})


// login checking for valid number or email and valid password
describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://amazon.in');
      cy.get('#nav-link-accountList-nav-line-1').click();
      cy.get('#ap_email').click().type(/*enter your email or mobile number */);
      cy.get('.a-button-inner > #continue').click();
      cy.get('#ap_password').click().type(/*enter your account password */);
      cy.get('#signInSubmit').click();
  })
})
