package com.sencha.gxt.theme.base.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellResources {
  private static ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator _instance0 = new ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator();
  private void arrowInitializer() {
    arrow = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "arrow",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 10, 10, false, false
    );
  }
  private static class arrowInitializer {
    static {
      _instance0.arrowInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return arrow;
    }
  }
  public com.google.gwt.resources.client.ImageResource arrow() {
    return arrowInitializer.get();
  }
  private void arrowBottomInitializer() {
    arrowBottom = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "arrowBottom",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 200, 14, false, false
    );
  }
  private static class arrowBottomInitializer {
    static {
      _instance0.arrowBottomInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return arrowBottom;
    }
  }
  public com.google.gwt.resources.client.ImageResource arrowBottom() {
    return arrowBottomInitializer.get();
  }
  private void splitInitializer() {
    split = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "split",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage1),
      0, 0, 14, 72, false, false
    );
  }
  private static class splitInitializer {
    static {
      _instance0.splitInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return split;
    }
  }
  public com.google.gwt.resources.client.ImageResource split() {
    return splitInitializer.get();
  }
  private void splitBottomInitializer() {
    splitBottom = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "splitBottom",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage2),
      0, 0, 200, 14, false, false
    );
  }
  private static class splitBottomInitializer {
    static {
      _instance0.splitBottomInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return splitBottom;
    }
  }
  public com.google.gwt.resources.client.ImageResource splitBottom() {
    return splitBottomInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellStyle() {
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
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GIAX32YDLM{cursor:" + ("pointer")  + ";white-space:" + ("nowrap")  + ";}.GIAX32YDMM .GIAX32YDDN{width:" + ("100%")  + ";}.GIAX32YDLM td{text-align:" + ("center")  + ";}.GIAX32YDLM td img{float:" + ("right")  + ";}.GIAX32YDAN td img,.GIAX32YDNM td img{float:" + ("none")  + ";}.GIAX32YDBN{padding:" + ("0"+ " " +"2px")  + ";}.GIAX32YDKN{padding:" + ("0"+ " " +"2px")  + ";font-family:" + ("Tahoma"+ ","+ " " +"Arial"+ ","+ " " +"Verdana"+ ","+ " " +"sans-serif")  + ";font-size:" + ("11px")  + ";font-weight:") + (("normal")  + ";text-align:" + ("center")  + ";cursor:" + ("pointer")  + ";white-space:" + ("nowrap")  + ";overflow:" + ("hidden")  + ";}.GIAX32YDBN div{font-size:" + ("1px")  + ";}.GIAX32YDHN .GIAX32YDOM td,.GIAX32YDHN .GIAX32YDPM td,.GIAX32YDHN .GIAX32YDFN td{line-height:" + ("18px")  + ";}.GIAX32YDEN .GIAX32YDAN .GIAX32YDBN div,.GIAX32YDEN .GIAX32YDNM .GIAX32YDBN div{height:" + ("20px")  + ";}.GIAX32YDEN .GIAX32YDOM td,.GIAX32YDEN .GIAX32YDPM td,.GIAX32YDEN .GIAX32YDFN td{line-height:" + ("24px")  + ";}.GIAX32YDEN .GIAX32YDAN .GIAX32YDBN div,.GIAX32YDEN .GIAX32YDNM .GIAX32YDBN div{height:" + ("26px")  + ";}.GIAX32YDCN .GIAX32YDOM td,.GIAX32YDCN .GIAX32YDPM td,.GIAX32YDCN .GIAX32YDFN td,.GIAX32YDCN .GIAX32YDBN div{line-height:" + ("32px") ) + (";}.GIAX32YDCN .GIAX32YDAN .GIAX32YDBN div,.GIAX32YDCN .GIAX32YDNM .GIAX32YDBN div{height:" + ("34px")  + ";}.GIAX32YDIN{height:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getHeight() + "px")  + ";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";background-position:" + ("left"+ " " +"center")  + ";padding-left:" + ("14px")  + ";background-repeat:" + ("no-repeat")  + ";}.GIAX32YDJN{height:") + (((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getHeight() + "px")  + ";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";gwt-image:" + ("\"splitBottom\"")  + ";background-position:" + ("center"+ " " +"bottom")  + ";padding-bottom:" + ("14px")  + ";background-repeat:" + ("no-repeat")  + ";}.GIAX32YDJM{height:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getHeight() + "px") ) + (";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";padding-left:" + ("10px")  + ";background-position:" + ("left"+ " " +"center")  + ";background-repeat:" + ("no-repeat")  + ";}.GIAX32YDKM{height:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getHeight() + "px")  + ";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getWidth() + "px")  + ";overflow:") + (("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";background-position:" + ("center"+ " " +"bottom")  + ";padding-bottom:" + ("14px")  + ";background-repeat:" + ("no-repeat")  + ";}")) : ((".GIAX32YDLM{cursor:" + ("pointer")  + ";white-space:" + ("nowrap")  + ";}.GIAX32YDMM .GIAX32YDDN{width:" + ("100%")  + ";}.GIAX32YDLM td{text-align:" + ("center")  + ";}.GIAX32YDLM td img{float:" + ("left")  + ";}.GIAX32YDAN td img,.GIAX32YDNM td img{float:" + ("none")  + ";}.GIAX32YDBN{padding:" + ("0"+ " " +"2px")  + ";}.GIAX32YDKN{padding:" + ("0"+ " " +"2px")  + ";font-family:" + ("Tahoma"+ ","+ " " +"Arial"+ ","+ " " +"Verdana"+ ","+ " " +"sans-serif")  + ";font-size:" + ("11px")  + ";font-weight:") + (("normal")  + ";text-align:" + ("center")  + ";cursor:" + ("pointer")  + ";white-space:" + ("nowrap")  + ";overflow:" + ("hidden")  + ";}.GIAX32YDBN div{font-size:" + ("1px")  + ";}.GIAX32YDHN .GIAX32YDOM td,.GIAX32YDHN .GIAX32YDPM td,.GIAX32YDHN .GIAX32YDFN td{line-height:" + ("18px")  + ";}.GIAX32YDEN .GIAX32YDAN .GIAX32YDBN div,.GIAX32YDEN .GIAX32YDNM .GIAX32YDBN div{height:" + ("20px")  + ";}.GIAX32YDEN .GIAX32YDOM td,.GIAX32YDEN .GIAX32YDPM td,.GIAX32YDEN .GIAX32YDFN td{line-height:" + ("24px")  + ";}.GIAX32YDEN .GIAX32YDAN .GIAX32YDBN div,.GIAX32YDEN .GIAX32YDNM .GIAX32YDBN div{height:" + ("26px")  + ";}.GIAX32YDCN .GIAX32YDOM td,.GIAX32YDCN .GIAX32YDPM td,.GIAX32YDCN .GIAX32YDFN td,.GIAX32YDCN .GIAX32YDBN div{line-height:" + ("32px") ) + (";}.GIAX32YDCN .GIAX32YDAN .GIAX32YDBN div,.GIAX32YDCN .GIAX32YDNM .GIAX32YDBN div{height:" + ("34px")  + ";}.GIAX32YDIN{height:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getHeight() + "px")  + ";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.split()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";background-position:" + ("right"+ " " +"center")  + ";padding-right:" + ("14px")  + ";background-repeat:" + ("no-repeat")  + ";}.GIAX32YDJN{height:") + (((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getHeight() + "px")  + ";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.splitBottom()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";gwt-image:" + ("\"splitBottom\"")  + ";background-position:" + ("center"+ " " +"bottom")  + ";padding-bottom:" + ("14px")  + ";background-repeat:" + ("no-repeat")  + ";}.GIAX32YDJM{height:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getHeight() + "px") ) + (";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrow()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";padding-right:" + ("10px")  + ";background-position:" + ("right"+ " " +"center")  + ";background-repeat:" + ("no-repeat")  + ";}.GIAX32YDKM{height:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getHeight() + "px")  + ";width:" + ((ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getWidth() + "px")  + ";overflow:") + (("hidden")  + ";background:" + ("url(\"" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getSafeUri().asString() + "\") -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getLeft() + "px -" + (ButtonCellDefaultAppearance_ButtonCellResources_safari_default_InlineClientBundleGenerator.this.arrowBottom()).getTop() + "px  no-repeat")  + ";width:" + ("auto")  + ";height:" + ("auto")  + ";background-position:" + ("center"+ " " +"bottom")  + ";padding-bottom:" + ("14px")  + ";background-repeat:" + ("no-repeat")  + ";}"));
      }
      public java.lang.String arrow() {
        return "GIAX32YDJM";
      }
      public java.lang.String arrowBottom() {
        return "GIAX32YDKM";
      }
      public java.lang.String button() {
        return "GIAX32YDLM";
      }
      public java.lang.String hasWidth() {
        return "GIAX32YDMM";
      }
      public java.lang.String iconBottom() {
        return "GIAX32YDNM";
      }
      public java.lang.String iconLeft() {
        return "GIAX32YDOM";
      }
      public java.lang.String iconRight() {
        return "GIAX32YDPM";
      }
      public java.lang.String iconTop() {
        return "GIAX32YDAN";
      }
      public java.lang.String iconWrap() {
        return "GIAX32YDBN";
      }
      public java.lang.String large() {
        return "GIAX32YDCN";
      }
      public java.lang.String mainTable() {
        return "GIAX32YDDN";
      }
      public java.lang.String medium() {
        return "GIAX32YDEN";
      }
      public java.lang.String noIcon() {
        return "GIAX32YDFN";
      }
      public java.lang.String over() {
        return "GIAX32YDGN";
      }
      public java.lang.String small() {
        return "GIAX32YDHN";
      }
      public java.lang.String split() {
        return "GIAX32YDIN";
      }
      public java.lang.String splitBottom() {
        return "GIAX32YDJN";
      }
      public java.lang.String text() {
        return "GIAX32YDKN";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAFklEQVR42mNgGFrgPxZMlGKiTB5MAAAf3gj4JnSxiwAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAAAOCAYAAABq6VM3AAAALUlEQVR42u3TMQ0AAAgEMfybBgP8xEibnISrAgAAAAAAjnoJCJMAYRIAAACeGvgeCPjeNr45AAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAABICAYAAADGScSgAAAAP0lEQVR42u3RsQkAMAgEQPffzIGsTQZIwHQp7uHLQ+EjdjKzq6rjNSAIgiAIfgz70PHFOxq82uYAQRAEwV/hAtuuENY01icUAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAAAOCAYAAABq6VM3AAAANklEQVR42u3VAQ0AAAjDMPzrwhcY4Apok0l4XgVk3T2S7mqAyIUCAAD8M0dAGAkQRgIAAMBTCyEZuLtPdFEgAAAAAElFTkSuQmCC";
  private static com.google.gwt.resources.client.ImageResource arrow;
  private static com.google.gwt.resources.client.ImageResource arrowBottom;
  private static com.google.gwt.resources.client.ImageResource split;
  private static com.google.gwt.resources.client.ImageResource splitBottom;
  private static com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      arrow(), 
      arrowBottom(), 
      split(), 
      splitBottom(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("arrow", arrow());
        resourceMap.put("arrowBottom", arrowBottom());
        resourceMap.put("split", split());
        resourceMap.put("splitBottom", splitBottom());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'arrow': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellResources::arrow()();
      case 'arrowBottom': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellResources::arrowBottom()();
      case 'split': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellResources::split()();
      case 'splitBottom': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellResources::splitBottom()();
      case 'style': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance.ButtonCellResources::style()();
    }
    return null;
  }-*/;
}
