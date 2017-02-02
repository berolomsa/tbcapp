package com.sencha.gxt.theme.base.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldResources {
  private static TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator _instance0 = new TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? (("input.GCGCW0WDHX,textarea.GCGCW0WDHX{border:" + ("1px"+ " " +"solid"+ " " +"#7eadd9")  + ";}input.GCGCW0WDIX,textarea.GCGCW0WDIX{height:" + ((TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getTop() + "px  repeat-x")  + ";background-color:" + ("#fff")  + ";background-position:" + ("bottom")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#c30")  + ";height:" + ("18px")  + ";line-height:" + ("18px")  + ";}.GCGCW0WDLX{position:" + ("relative")  + ";right:") + (("0")  + ";top:" + ("0")  + ";zoom:" + ("1")  + ";white-space:" + ("nowrap")  + ";text-align:" + ("right")  + ";}.GCGCW0WDFX{font:" + ("12px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";}.GCGCW0WDEX{color:" + ("gray")  + ";}.GCGCW0WDKX{height:" + ((TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getTop() + "px  repeat-x")  + ";height:" + ("auto") ) + (";background-color:" + ("#fff")  + ";border:" + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";padding:" + ("1px"+ " " +"3px")  + ";resize:" + ("none")  + ";height:" + ("18px")  + ";line-height:" + ("18px")  + ";vertical-align:" + ("top")  + ";}.GCGCW0WDDX{background-color:" + ("#fff")  + ";border:" + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";padding:" + ("1px"+ " " +"3px")  + ";resize:") + (("none")  + ";overflow:" + ("visible")  + ";}")) : (("input.GCGCW0WDHX,textarea.GCGCW0WDHX{border:" + ("1px"+ " " +"solid"+ " " +"#7eadd9")  + ";}input.GCGCW0WDIX,textarea.GCGCW0WDIX{height:" + ((TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.invalidLine()).getTop() + "px  repeat-x")  + ";background-color:" + ("#fff")  + ";background-position:" + ("bottom")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#c30")  + ";height:" + ("18px")  + ";line-height:" + ("18px")  + ";}.GCGCW0WDLX{position:" + ("relative")  + ";left:") + (("0")  + ";top:" + ("0")  + ";zoom:" + ("1")  + ";white-space:" + ("nowrap")  + ";text-align:" + ("left")  + ";}.GCGCW0WDFX{font:" + ("12px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";}.GCGCW0WDEX{color:" + ("gray")  + ";}.GCGCW0WDKX{height:" + ((TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_safari_default_InlineClientBundleGenerator.this.textBackground()).getTop() + "px  repeat-x")  + ";height:" + ("auto") ) + (";background-color:" + ("#fff")  + ";border:" + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";padding:" + ("1px"+ " " +"3px")  + ";resize:" + ("none")  + ";height:" + ("18px")  + ";line-height:" + ("18px")  + ";vertical-align:" + ("top")  + ";}.GCGCW0WDDX{background-color:" + ("#fff")  + ";border:" + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";padding:" + ("1px"+ " " +"3px")  + ";resize:") + (("none")  + ";overflow:" + ("visible")  + ";}"));
      }
      public java.lang.String area() {
        return "GCGCW0WDDX";
      }
      public java.lang.String empty() {
        return "GCGCW0WDEX";
      }
      public java.lang.String field() {
        return "GCGCW0WDFX";
      }
      public java.lang.String file() {
        return "GCGCW0WDGX";
      }
      public java.lang.String focus() {
        return "GCGCW0WDHX";
      }
      public java.lang.String invalid() {
        return "GCGCW0WDIX";
      }
      public java.lang.String readonly() {
        return "GCGCW0WDJX";
      }
      public java.lang.String text() {
        return "GCGCW0WDKX";
      }
      public java.lang.String wrap() {
        return "GCGCW0WDLX";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle get() {
      return css;
    }
  }
  public com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle css() {
    return cssInitializer.get();
  }
  private void invalidLineInitializer() {
    invalidLine = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "invalidLine",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 4, 3, false, false
    );
  }
  private static class invalidLineInitializer {
    static {
      _instance0.invalidLineInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return invalidLine;
    }
  }
  public com.google.gwt.resources.client.ImageResource invalidLine() {
    return invalidLineInitializer.get();
  }
  private void textBackgroundInitializer() {
    textBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 1, 18, false, false
    );
  }
  private static class textBackgroundInitializer {
    static {
      _instance0.textBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource textBackground() {
    return textBackgroundInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle css;
  private static final java.lang.String externalImage = GWT.getModuleBaseForStaticFiles() + "2659A66C9CEC1586DA091ACEC4A3AE6B.cache.png";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAASCAYAAACaV7S8AAAANElEQVR42pXEuQnAQAwAwe2/SCcGxwYhhLhn7RZuguG6H3kjJDIlq6S6pceQOZesvcXfUR9VjEbUejI8wwAAAABJRU5ErkJggg==";
  private static com.google.gwt.resources.client.ImageResource invalidLine;
  private static com.google.gwt.resources.client.ImageResource textBackground;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
      invalidLine(), 
      textBackground(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
        resourceMap.put("invalidLine", invalidLine());
        resourceMap.put("textBackground", textBackground());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldResources::css()();
      case 'invalidLine': return this.@com.sencha.gxt.theme.base.client.field.ValueBaseFieldDefaultAppearance.ValueBaseFieldResources::invalidLine()();
      case 'textBackground': return this.@com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldResources::textBackground()();
    }
    return null;
  }-*/;
}
