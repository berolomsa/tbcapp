package com.sencha.gxt.theme.blue.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueThemeAppearance_Bundle_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.BlueThemeAppearance.Bundle {
  private static BlueThemeAppearance_Bundle_safari_default_InlineClientBundleGenerator _instance0 = new BlueThemeAppearance_Bundle_safari_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.sencha.gxt.theme.blue.client.BlueThemeAppearance.BlueStyles() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((":focus{outline:" + ("none")  + " !important;}.GIAX32YDDPB{border:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDHPB{border:" + ("none")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDIPB{border:" + ("none")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDJPB{border:" + ("none")  + ";border-top:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDEPB{border:" + ("none")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDKPB{color:") + (("gray")  + " !important;cursor:" + ("default")  + " !important;opacity:" + ("0.6")  + ";}.GIAX32YDKPB *{cursor:" + ("default")  + " !important;}")) : ((":focus{outline:" + ("none")  + " !important;}.GIAX32YDDPB{border:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDHPB{border:" + ("none")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDIPB{border:" + ("none")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDJPB{border:" + ("none")  + ";border-top:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDEPB{border:" + ("none")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;}.GIAX32YDKPB{color:") + (("gray")  + " !important;cursor:" + ("default")  + " !important;opacity:" + ("0.6")  + ";}.GIAX32YDKPB *{cursor:" + ("default")  + " !important;}"));
      }
      public java.lang.String backgroundColorLight() {
        return "#e0e8f8";
      }
      public java.lang.String border() {
        return "GIAX32YDDPB";
      }
      public java.lang.String borderBottom() {
        return "GIAX32YDEPB";
      }
      public java.lang.String borderColor() {
        return "#99bbe8";
      }
      public java.lang.String borderColorLight() {
        return "orange";
      }
      public java.lang.String borderLeft() {
        return "GIAX32YDHPB";
      }
      public java.lang.String borderRight() {
        return "GIAX32YDIPB";
      }
      public java.lang.String borderTop() {
        return "GIAX32YDJPB";
      }
      public java.lang.String disabled() {
        return "GIAX32YDKPB";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.theme.blue.client.BlueThemeAppearance.BlueStyles get() {
      return css;
    }
  }
  public com.sencha.gxt.theme.blue.client.BlueThemeAppearance.BlueStyles css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.blue.client.BlueThemeAppearance.BlueStyles css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.sencha.gxt.theme.blue.client.BlueThemeAppearance.Bundle::css()();
    }
    return null;
  }-*/;
}
