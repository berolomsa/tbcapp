package com.sencha.gxt.core.client.dom;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Layer_LayerResources_default_InlineClientBundleGenerator implements com.sencha.gxt.core.client.dom.Layer.LayerResources {
  private static Layer_LayerResources_default_InlineClientBundleGenerator _instance0 = new Layer_LayerResources_default_InlineClientBundleGenerator();
  private void bottomCenterInitializer() {
    bottomCenter = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "bottomCenter",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 1, 6, false, false
    );
  }
  private static class bottomCenterInitializer {
    static {
      _instance0.bottomCenterInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return bottomCenter;
    }
  }
  public com.google.gwt.resources.client.ImageResource bottomCenter() {
    return bottomCenterInitializer.get();
  }
  private void bottomLeftInitializer() {
    bottomLeft = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "bottomLeft",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 6, 6, false, false
    );
  }
  private static class bottomLeftInitializer {
    static {
      _instance0.bottomLeftInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return bottomLeft;
    }
  }
  public com.google.gwt.resources.client.ImageResource bottomLeft() {
    return bottomLeftInitializer.get();
  }
  private void bottomRightInitializer() {
    bottomRight = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "bottomRight",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage1),
      0, 0, 6, 6, false, false
    );
  }
  private static class bottomRightInitializer {
    static {
      _instance0.bottomRightInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return bottomRight;
    }
  }
  public com.google.gwt.resources.client.ImageResource bottomRight() {
    return bottomRightInitializer.get();
  }
  private void middleCenterInitializer() {
    middleCenter = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "middleCenter",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage2),
      0, 0, 1, 1, false, false
    );
  }
  private static class middleCenterInitializer {
    static {
      _instance0.middleCenterInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return middleCenter;
    }
  }
  public com.google.gwt.resources.client.ImageResource middleCenter() {
    return middleCenterInitializer.get();
  }
  private void middleLeftInitializer() {
    middleLeft = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "middleLeft",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage3),
      0, 0, 6, 1, false, false
    );
  }
  private static class middleLeftInitializer {
    static {
      _instance0.middleLeftInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return middleLeft;
    }
  }
  public com.google.gwt.resources.client.ImageResource middleLeft() {
    return middleLeftInitializer.get();
  }
  private void middleRightInitializer() {
    middleRight = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "middleRight",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage4),
      0, 0, 6, 1, false, false
    );
  }
  private static class middleRightInitializer {
    static {
      _instance0.middleRightInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return middleRight;
    }
  }
  public com.google.gwt.resources.client.ImageResource middleRight() {
    return middleRightInitializer.get();
  }
  private void topCenterInitializer() {
    topCenter = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "topCenter",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage5),
      0, 0, 1, 6, false, false
    );
  }
  private static class topCenterInitializer {
    static {
      _instance0.topCenterInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return topCenter;
    }
  }
  public com.google.gwt.resources.client.ImageResource topCenter() {
    return topCenterInitializer.get();
  }
  private void topLeftInitializer() {
    topLeft = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "topLeft",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage6),
      0, 0, 6, 6, false, false
    );
  }
  private static class topLeftInitializer {
    static {
      _instance0.topLeftInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return topLeft;
    }
  }
  public com.google.gwt.resources.client.ImageResource topLeft() {
    return topLeftInitializer.get();
  }
  private void topRightInitializer() {
    topRight = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "topRight",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage7),
      0, 0, 6, 6, false, false
    );
  }
  private static class topRightInitializer {
    static {
      _instance0.topRightInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return topRight;
    }
  }
  public com.google.gwt.resources.client.ImageResource topRight() {
    return topRightInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.core.client.dom.Layer.LayerStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GIAX32YDOI{position:" + ("absolute")  + ";visibility:" + ("hidden")  + ";right:" + ("0")  + ";top:" + ("0")  + ";overflow:" + ("hidden")  + ";}.GIAX32YDMI{position:" + ("absolute")  + ";}.GIAX32YDMI *{overflow:" + ("hidden")  + ";padding:" + ("0")  + ";border:" + ("0")  + ";margin:" + ("0")  + ";clear:") + (("none")  + ";}.GIAX32YDAJ,.GIAX32YDFI{height:" + ("6px")  + ";float:" + ("right")  + ";}.GIAX32YDBJ,.GIAX32YDCJ,.GIAX32YDGI,.GIAX32YDHI{width:" + ("6px")  + ";height:" + ("6px")  + ";float:" + ("right")  + ";}.GIAX32YDII{width:" + ("100%")  + ";}.GIAX32YDKI,.GIAX32YDLI{width:" + ("6px")  + ";float:" + ("right")  + ";height:" + ("100%")  + ";}.GIAX32YDJI{float:" + ("right") ) + (";height:" + ("100%")  + ";background:" + ("transparent")  + ";}.GIAX32YDPI,.GIAX32YDEI{height:" + ("6px")  + ";overflow:" + ("hidden")  + ";width:" + ("100%")  + ";}.GIAX32YDBJ{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getHeight() + "px")  + ";width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getTop() + "px  no-repeat")  + ";}.GIAX32YDAJ{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getHeight() + "px")  + ";overflow:") + (("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getTop() + "px  repeat-x")  + ";}.GIAX32YDCJ{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getHeight() + "px")  + ";width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getTop() + "px  no-repeat")  + ";}.GIAX32YDKI{width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getTop() + "px  repeat-y")  + ";}.GIAX32YDJI{overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleCenter()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleCenter()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleCenter()).getTop() + "px  repeat") ) + (";}.GIAX32YDLI{width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getTop() + "px  repeat-y")  + ";}.GIAX32YDGI{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getHeight() + "px")  + ";width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getTop() + "px  no-repeat")  + ";}.GIAX32YDFI{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getTop() + "px  repeat-x")  + ";}.GIAX32YDHI{height:") + (((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getTop() + "px  repeat-x")  + ";}")) : ((".GIAX32YDOI{position:" + ("absolute")  + ";visibility:" + ("hidden")  + ";left:" + ("0")  + ";top:" + ("0")  + ";overflow:" + ("hidden")  + ";}.GIAX32YDMI{position:" + ("absolute")  + ";}.GIAX32YDMI *{overflow:" + ("hidden")  + ";padding:" + ("0")  + ";border:" + ("0")  + ";margin:" + ("0")  + ";clear:") + (("none")  + ";}.GIAX32YDAJ,.GIAX32YDFI{height:" + ("6px")  + ";float:" + ("left")  + ";}.GIAX32YDBJ,.GIAX32YDCJ,.GIAX32YDGI,.GIAX32YDHI{width:" + ("6px")  + ";height:" + ("6px")  + ";float:" + ("left")  + ";}.GIAX32YDII{width:" + ("100%")  + ";}.GIAX32YDKI,.GIAX32YDLI{width:" + ("6px")  + ";float:" + ("left")  + ";height:" + ("100%")  + ";}.GIAX32YDJI{float:" + ("left") ) + (";height:" + ("100%")  + ";background:" + ("transparent")  + ";}.GIAX32YDPI,.GIAX32YDEI{height:" + ("6px")  + ";overflow:" + ("hidden")  + ";width:" + ("100%")  + ";}.GIAX32YDBJ{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getHeight() + "px")  + ";width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topLeft()).getTop() + "px  no-repeat")  + ";}.GIAX32YDAJ{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getHeight() + "px")  + ";overflow:") + (("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topCenter()).getTop() + "px  repeat-x")  + ";}.GIAX32YDCJ{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getHeight() + "px")  + ";width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.topRight()).getTop() + "px  no-repeat")  + ";}.GIAX32YDKI{width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleLeft()).getTop() + "px  repeat-y")  + ";}.GIAX32YDJI{overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleCenter()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleCenter()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleCenter()).getTop() + "px  repeat") ) + (";}.GIAX32YDLI{width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.middleRight()).getTop() + "px  repeat-y")  + ";}.GIAX32YDGI{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getHeight() + "px")  + ";width:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomLeft()).getTop() + "px  no-repeat")  + ";}.GIAX32YDFI{height:" + ((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomCenter()).getTop() + "px  repeat-x")  + ";}.GIAX32YDHI{height:") + (((Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getSafeUri().asString() + "\") -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getLeft() + "px -" + (Layer_LayerResources_default_InlineClientBundleGenerator.this.bottomRight()).getTop() + "px  repeat-x")  + ";}"));
      }
      public java.lang.String bottom() {
        return "GIAX32YDEI";
      }
      public java.lang.String bottomCenter() {
        return "GIAX32YDFI";
      }
      public java.lang.String bottomLeft() {
        return "GIAX32YDGI";
      }
      public java.lang.String bottomRight() {
        return "GIAX32YDHI";
      }
      public java.lang.String middle() {
        return "GIAX32YDII";
      }
      public java.lang.String middleCenter() {
        return "GIAX32YDJI";
      }
      public java.lang.String middleLeft() {
        return "GIAX32YDKI";
      }
      public java.lang.String middleRight() {
        return "GIAX32YDLI";
      }
      public java.lang.String shadow() {
        return "GIAX32YDMI";
      }
      public int shadowOffset() {
        return 4;
      }
      public java.lang.String shim() {
        return "GIAX32YDOI";
      }
      public java.lang.String top() {
        return "GIAX32YDPI";
      }
      public java.lang.String topCenter() {
        return "GIAX32YDAJ";
      }
      public java.lang.String topLeft() {
        return "GIAX32YDBJ";
      }
      public java.lang.String topRight() {
        return "GIAX32YDCJ";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.core.client.dom.Layer.LayerStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.core.client.dom.Layer.LayerStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAGCAYAAAACEPQxAAAAG0lEQVR42mNgYGBwAGIGaxBhDCI0QIQ0iBAAABEPAQJ7KcsKAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAAGCAYAAADgzO9IAAAAT0lEQVR42i3MOwqAQBRD0eCfUUaLAbWxEewsBAv3vzLvgxSnuiSSNGDGjgsPPqhHxooTN94IHSYUHF5FVIuEBZtjLFV7NToW36pC45h8m38D0QL+NSmvrgAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAAGCAYAAADgzO9IAAAAUElEQVR42i3MOwqAQBAE0cY/uqjBwmpiIpgZCAbe/2TWQAcvKXpGkj48uLBjwQC9uHGiYEYvx1gfyEjo5GXEDStGtPJ5dpy8ruWfycuIDaofGgUC/hVWAkoAAAAASUVORK5CYII=";
  private static final java.lang.String externalImage2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNgYGCwAAAAPQA50xFYowAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage3 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAABCAYAAAD9yd/wAAAAGUlEQVR42mNgYGDgAGIBIJYGYg0gNgZiawAF0gDK5idT3wAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage4 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAABCAYAAAD9yd/wAAAAGUlEQVR42mNgYGCwBmJjINYAYmkgFgBiDgALpgDKpiH/eAAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage5 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAGCAYAAAACEPQxAAAAG0lEQVR42mNgYGAQAGIGaRChASKMQYQ1iHAAAApIAQIi1iveAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage6 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAAGCAYAAADgzO9IAAAAUklEQVR42i3MOwqAQBAE0cE/uqiBsGtiIpgZCAbe/2RWQwcv6SkmIqJCgw4jEmZE7XHCig1Zh9alxoIDZ7hOLjVeuHXo/TO71PjqMGDB7vrB9wOefQL+mU9GkwAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage7 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAAGCAYAAADgzO9IAAAAUklEQVR42i3NOwqAQBAE0cE/KmqwsJqYLJgZCAbe/2RWQwcvKnomImLBjBEdGlSIjIQNk2OtUHBid9SyVbhxOSaf1Spex+Kz+tkrfHi8OrBi+AG0sQL+2OFZNQAAAABJRU5ErkJggg==";
  private static com.google.gwt.resources.client.ImageResource bottomCenter;
  private static com.google.gwt.resources.client.ImageResource bottomLeft;
  private static com.google.gwt.resources.client.ImageResource bottomRight;
  private static com.google.gwt.resources.client.ImageResource middleCenter;
  private static com.google.gwt.resources.client.ImageResource middleLeft;
  private static com.google.gwt.resources.client.ImageResource middleRight;
  private static com.google.gwt.resources.client.ImageResource topCenter;
  private static com.google.gwt.resources.client.ImageResource topLeft;
  private static com.google.gwt.resources.client.ImageResource topRight;
  private static com.sencha.gxt.core.client.dom.Layer.LayerStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      bottomCenter(), 
      bottomLeft(), 
      bottomRight(), 
      middleCenter(), 
      middleLeft(), 
      middleRight(), 
      topCenter(), 
      topLeft(), 
      topRight(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("bottomCenter", bottomCenter());
        resourceMap.put("bottomLeft", bottomLeft());
        resourceMap.put("bottomRight", bottomRight());
        resourceMap.put("middleCenter", middleCenter());
        resourceMap.put("middleLeft", middleLeft());
        resourceMap.put("middleRight", middleRight());
        resourceMap.put("topCenter", topCenter());
        resourceMap.put("topLeft", topLeft());
        resourceMap.put("topRight", topRight());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'bottomCenter': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::bottomCenter()();
      case 'bottomLeft': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::bottomLeft()();
      case 'bottomRight': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::bottomRight()();
      case 'middleCenter': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::middleCenter()();
      case 'middleLeft': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::middleLeft()();
      case 'middleRight': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::middleRight()();
      case 'topCenter': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::topCenter()();
      case 'topLeft': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::topLeft()();
      case 'topRight': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::topRight()();
      case 'style': return this.@com.sencha.gxt.core.client.dom.Layer.LayerResources::style()();
    }
    return null;
  }-*/;
}
