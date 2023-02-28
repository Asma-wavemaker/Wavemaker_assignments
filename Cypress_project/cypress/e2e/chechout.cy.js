describe('template spec', () => {
    it('passes', () => {
      cy.visit('https://amazon.in');
      cy.get('#nav-link-accountList-nav-line-1').click();
      cy.get('#ap_email').click().type(/*enter your email or mobile number */);
      cy.get('.a-button-inner > #continue').click();
      cy.get('#ap_password').click().type(/*enter your account password */);
      cy.get('#signInSubmit').click();

    // view items in cart
      cy.get('#nav-cart-count').click();
      
    // proceed to pay
      cy.get('#sc-buy-box-ptc-button > .a-button-inner > .a-button-input').click();
    })
  })