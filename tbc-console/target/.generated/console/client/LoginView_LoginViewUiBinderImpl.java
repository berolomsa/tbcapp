package console.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class LoginView_LoginViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, console.client.LoginView>, console.client.LoginView.LoginViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<section class='login-form'> <header> <h1>გთხოვთ შეხვიდეთ სისტემაში</h1> </header> <section> <div class='error-message'> <span id='{0}'></span> </div> <form id='auth-form'> <dl class='clearfix'> <dt><label>მომხმარებელი: </label></dt> <dd class='text-input'><span id='{1}'></span></dd> </dl> <dl class='clearfix'> <dt><label>პაროლი: </label></dt> <dd class='text-input'><span id='{2}'></span></dd> </dl> <div class='action-bar'> <span id='{3}'></span> </div> </form> </section> </section>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<header class='theader'> <div class='toolbar'> </div> </header> <span id='{0}'></span> <footer> </footer>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final console.client.LoginView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final console.client.LoginView owner;


    final com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = (com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler) new com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler() {
      public void onSelect(com.sencha.gxt.widget.core.client.event.SelectEvent event) {
        owner.onSubmitClicked((com.sencha.gxt.widget.core.client.event.SelectEvent) event);
      }
    };

    public Widgets(final console.client.LoginView owner) {
      this.owner = owner;
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1(), get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private console.client.LoginView_LoginViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private console.client.LoginView_LoginViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final console.client.LoginView_LoginViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (console.client.LoginView_LoginViewUiBinderImpl_GenBundle) GWT.create(console.client.LoginView_LoginViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord0.detach();
      f_HTMLPanel1.addAndReplaceElement(get_loginPanel(), get_domId0Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for loginPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loginPanel() {
      return build_loginPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loginPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loginPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      loginPanel.setVisible(false);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(loginPanel.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord1.detach();
      loginPanel.addAndReplaceElement(get_errorLabel(), get_domId1Element().get());
      loginPanel.addAndReplaceElement(get_username(), get_domId2Element().get());
      loginPanel.addAndReplaceElement(get_password(), get_domId3Element().get());
      loginPanel.addAndReplaceElement(get_submitButton(), get_domId4Element().get());

      this.owner.loginPanel = loginPanel;

      return loginPanel;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for errorLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_errorLabel() {
      return build_errorLabel();
    }
    private com.google.gwt.user.client.ui.Label build_errorLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      this.owner.errorLabel = errorLabel;

      return errorLabel;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for username called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.sencha.gxt.widget.core.client.form.TextField get_username() {
      return build_username();
    }
    private com.sencha.gxt.widget.core.client.form.TextField build_username() {
      // Creation section.
      final com.sencha.gxt.widget.core.client.form.TextField username = (com.sencha.gxt.widget.core.client.form.TextField) GWT.create(com.sencha.gxt.widget.core.client.form.TextField.class);
      // Setup section.


      this.owner.username = username;

      return username;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for password called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.sencha.gxt.widget.core.client.form.PasswordField get_password() {
      return build_password();
    }
    private com.sencha.gxt.widget.core.client.form.PasswordField build_password() {
      // Creation section.
      final com.sencha.gxt.widget.core.client.form.PasswordField password = (com.sencha.gxt.widget.core.client.form.PasswordField) GWT.create(com.sencha.gxt.widget.core.client.form.PasswordField.class);
      // Setup section.


      this.owner.password = password;

      return password;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for submitButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.sencha.gxt.widget.core.client.button.TextButton get_submitButton() {
      return build_submitButton();
    }
    private com.sencha.gxt.widget.core.client.button.TextButton build_submitButton() {
      // Creation section.
      final com.sencha.gxt.widget.core.client.button.TextButton submitButton = (com.sencha.gxt.widget.core.client.button.TextButton) GWT.create(com.sencha.gxt.widget.core.client.button.TextButton.class);
      // Setup section.
      submitButton.setText("შესვლა");
      submitButton.addSelectHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      this.owner.submitButton = submitButton;

      return submitButton;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }
  }
}
