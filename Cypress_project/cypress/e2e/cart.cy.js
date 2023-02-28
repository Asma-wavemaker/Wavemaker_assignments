describe('template spec', () => {
    it('passes', () => {
        cy.visit('https://amazon.in');
        cy.get('#nav-link-accountList-nav-line-1').click();
        cy.get('#ap_email').click().type(/*enter your email or mobile number */);
        cy.get('.a-button-inner > #continue').click();
        cy.get('#ap_password').click().type(/*enter your account password */);
        cy.get('#signInSubmit').click();

      cy.wait(2000);

    //   search product 1
      cy.get('#twotabsearchtextbox').click().type('shampoo');
      cy.get('#nav-search-submit-button').click();
      cy.wait(2000);

    //   add to cart product 1
      cy.get('#a-autoid-1-announce').click();

    //   search product 2
      cy.get('#twotabsearchtextbox').click().clear().type('soaps');
      cy.get('#nav-search-submit-button').click();
      cy.wait(2000);

    //   add to cart product 2
      cy.get('#a-autoid-23').click();

    //   view items in cart
      cy.get('#nav-cart-count').click();
      
    })
  })
