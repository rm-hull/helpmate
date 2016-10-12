;; The MIT License (MIT)
;;
;; Copyright (c) 2016 Richard Hull
;;
;; Permission is hereby granted, free of charge, to any person obtaining a copy
;; of this software and associated documentation files (the "Software"), to deal
;; in the Software without restriction, including without limitation the rights
;; to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;; copies of the Software, and to rpermit persons to whom the Software is
;; furnished to do so, subject to the following conditions:
;;
;; The above copyright notice and this permission notice shall be included in all
;; copies or substantial portions of the Software.
;;
;; THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;; IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;; FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;; AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;; LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;; OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;; SOFTWARE.

(ns helpmate.svg
  (:refer-clojure :exclude [filter set symbol use])
  (:require
   [helpmate.core :refer [defelem]]))

(defelem animate
  "The animate element is put inside a shape element and defines how an
  attribute of an element changes over the animation. The attribute will
  change from the initial value to the end value in the duration specified.
  Example:

    <?xml version=\"1.0\"?>
    <svg width=\"120\" height=\"120\" viewPort=\"0 0 120 120\" version=\"1.1\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <rect x=\"10\" y=\"10\" width=\"100\" height=\"100\">
        <animate attributeType=\"XML\" attributeName=\"x\" from=\"-100\" to=\"120\"
            dur=\"10s\" repeatCount=\"indefinite\"/>
      </rect>
    </svg>")

(defelem animateMotion
  "The <animateMotion> element causes a referenced element to move along a
  motion path.")

(defelem animateTransform
  "The animateTransform element animates a transformation attribute on a target
  element, thereby allowing animations to control translation, scaling,
  rotation and/or skewing. Example:

    <?xml version=\"1.0\"?>
    <svg width=\"120\" height=\"120\"  viewBox=\"0 0 120 120\"
         xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\"
         xmlns:xlink=\"http://www.w3.org/1999/xlink\" >

        <polygon points=\"60,30 90,90 30,90\">
            <animateTransform attributeName=\"transform\"
                              attributeType=\"XML\"
                              type=\"rotate\"
                              from=\"0 60 70\"
                              to=\"360 60 70\"
                              dur=\"10s\"
                              repeatCount=\"indefinite\"/>
        </polygon>
    </svg>")

(defelem circle
  "The <circle> SVG element is an SVG basic shape, used to create circles based
  on a center point and a radius.")

(defelem clipPath

  "The <clipPath> SVG element defines a clipping path. A clipping path is
  used/referenced using the clip-path property.

  The clipping path restricts the region to which paint can be applied.
  Conceptually, any parts of the drawing that lie outside of the region
  bounded by the currently active clipping path are not drawn.

  A clipping path is conceptually equivalent to a custom viewport for the
  referencing element. Thus, it affects the rendering of an element, but not
  the element's inherent geometry. The bounding box of a clipped element
  (meaning, an element which references a <clipPath> element via a clip-path
  property, or a child of the referencing element) must remain the same as if
  it were not clipped.

  By default, pointer-events must not be dispatched on the clipped
  (non-visible) regions of a shape. For example, a circle with a radius of 10
  which is clipped to a circle with a radius of 5 will not receive \"click\"
  events outside the smaller radius. Example:

    <svg width=\"120\" height=\"120\" xmlns=\"http://www.w3.org/2000/svg\">
      <defs>
        <clipPath id=\"myClip\">
          <circle cx=\"30\" cy=\"30\" r=\"20\"/>
          <circle cx=\"70\" cy=\"70\" r=\"20\"/>
        </clipPath>
      </defs>

      <rect x=\"10\" y=\"10\" width=\"100\" height=\"100\"
          clip-path=\"url(#myClip)\"/>
    </svg>")

(defelem color-profile
  "The <color-profile> element allows describing the color profile used for the
  image.")

(defelem defs
  "SVG allows graphical objects to be defined for later reuse. It is
  recommended that, wherever possible, referenced elements be defined inside
  of a <defs> element. Defining these elements inside of a <defs> element
  promotes understandability of the SVG content and thus promotes
  accessibility. Graphical elements defined in a <defs> element will not be
  directly rendered. You can use a <use> element to render those elements
  wherever you want on the viewport.")

(defelem desc
  "Each container element or graphics element in an SVG drawing can supply a
  description string using the <desc> element where the description is
  text-only.

  When the current SVG document fragment is rendered as SVG on visual media,
  <desc> elements are not rendered as part of the graphics. Alternate
  presentations are possible, both visual and aural, which display the <desc>
  element but do not display <path> elements or other graphics elements. The
  <desc> element generally improves accessibility of SVG documents.")

(defelem discard
  "The <discard> SVG element allows authors to specify the time at which
  particular elements are to be discarded, thereby reducing the resources
  required by an SVG user agent. This is particularly useful to help SVG
  viewers conserve memory while displaying long-running documents.

  The <discard> element may occur wherever the <animate> element may.")

(defelem ellipse
  "The ellipse element is an SVG basic shape, used to create ellipses based on
  a center coordinate, and both their x and y radius.

  Ellipses are unable to specify the exact orientation of the ellipse (if, for
  example, you wanted to draw an ellipse tilted at a 45 degree angle), but can
  be rotated by using the transform attribute.")

(defelem feBlend
  "The <feBlend> SVG filter primitive composes two objects together ruled by a
  certain blending mode. This is similar to what is known from image editing
  software when blending two layers. The mode is defined by the mode
  attribute.")

(defelem feColorMatrix
  "The <feColorMatrix> SVG filter element changes colors based on a
  transformation matrix. Every pixel's color value (represented by an
  [R,G,B,A] vector) is matrix multiplied to create a new color.")

(defelem feComponentTransform
  "The <feComponentTransfer> SVG filter primitive performs color-component-wise
  remapping of data for each pixel. It allows operations like brightness
  adjustment, contrast adjustment, color balance or thresholding.

  The calculations are performed on non-premultiplied color values. The colors
  are modified by changing each channel (R, G, B, and A) to the result of what
  the children <feFuncR>, <feFuncB>, <feFuncG>, and <feFuncA> return.")

(defelem feComposite

  "This filter primitive performs the combination of two input images
  pixel-wise in image space using one of the Porter-Duff compositing
  operations: over, in, atop, out, xor and lighter. Additionally, a
  component-wise arithmetic operation (with the result clamped between [0..1])
  can be applied.

  The arithmetic operation is useful for combining the output from the
  <feDiffuseLighting> and <feSpecularLighting> filters with texture data. If
  the arithmetic operation is chosen, each result pixel is computed using the
  following formula:

    result = k1*i1*i2 + k2*i1 + k3*i2 + k4

  where:

    * i1 and i2 indicate the corresponding pixel channel values of the input
      image, which map to in and in2 respectively

    * k1, k2, k3 and k4 indicate the values of the attributes with the same
      name")

(defelem feConvolveMatrix
  "The <feConvolveMatrix> SVG filter primitive applies a matrix convolution
  filter effect. A convolution combines pixels in the input image with
  neighboring pixels to produce a resulting image. A wide variety of imaging
  operations can be achieved through convolutions, including blurring, edge
  detection, sharpening, embossing and beveling.")

(defelem feDiffuseLighting
  "The <feDiffuseLighting> SVG filter primitive lights an image using the alpha
  channel as a bump map. The resulting image, which is an RGBA opaque image,
  depends on the light color, light position and surface geometry of the input
  bump map.

  The light map produced by this filter primitive can be combined with a
  texture image using the multiply term of the arithmetic operator of the
  <feComposite> filter primitive. Multiple light sources can be simulated by
  adding several of these light maps together before applying it to the
  texture image.")

(defelem feDisplacementMap
  "The <feDisplacementMap> SVG filter primitive uses the pixel values from the
  image from in2 to spatially displace the image from in.

  The formula for the transformation looks like this:

    P'(x,y) ← P( x + scale * (XC(x,y) - 0.5), y + scale * (YC(x,y) - 0.5))

  where P(x,y) is the input image, in, and P'(x,y) is the destination. XC(x,y)
  and YC(x,y) are the component values of the channel designated by
  xChannelSelector and yChannelSelector.")

(defelem feDistantLight
  "The <feDistantLight> filter primitive defines a distant light source that
  can be used within a lighting filter primitive: <feDiffuseLighting> or
  <feSpecularLighting>.")

(defelem feDropShadow
  "The <feDropShadow> filter primitive creates a drop shadow of the input
  image. It is a shorthand filter, and is defined in terms of combinations of
  other filter primitives.")

(defelem feFlood
  "The <feFlood> SVG filter primitive fills the filter subregion with the color
  and opacity defined by flood-color and flood-opacity.")

(defelem feFuncA
  "The <feFuncA> SVG filter primitive defines the transfer function for the
  alpha component of the input graphic of its parent <feComponentTransfer>
  element.")

(defelem feFuncB
  "The <feFuncB> SVG filter primitive defines the transfer function for the
  blue component of the input graphic of its parent <feComponentTransfer>
  element.")

(defelem feFuncG
  "The <feFuncG> SVG filter primitive defines the transfer function for the
  green component of the input graphic of its parent <feComponentTransfer>
  element.")

(defelem feFuncR
  "The <feFuncR> SVG filter primitive defines the transfer function for the
  red component of the input graphic of its parent <feComponentTransfer>
  element.")

(defelem feGaussianBlur
  "The <feGaussianBlur> SVG filter primitive blurs the input image by the
  amount specified in stdDeviation, which defines the bell-curve.")

(defelem feImage
  "The <feImage> SVG filter primitive fetches image data from an external
  source and provides the pixel data as output (meaning if the external source
  is an SVG image, it is rasterized.)")

(defelem feMerge
  "The <feMerge> SVG element allows filter effects to be applied concurrently
  instead of sequentially. This is achieved by other filters storing their
  output via the result attribute and then accessing it in a <feMergeNode>
  child.")

(defelem feMergeNode
  "The feMergeNode takes the result of another filter to be processed by its
  parent <feMerge>.")

(defelem feMorphology
  "The <feMorphology> SVG filter primitive is used to erode or dilate the input
  image. It's usefulness lies especially in fattening or thinning effects.")

(defelem feOffset
  "The <feOffset> SVG filter primitive allows to offset the input image. The
  input image as a whole is offset by the values specified in the dx and dy
  attributes.")

(defelem fePointLight
  "The <fePointLight> SVG filter primitive allows to create a point light
  effect.")

(defelem feSpecularLighting
  "The <feSpecularLighting> SVG filter primitive lights a source graphic using
  the alpha channel as a bump map. The resulting image is an RGBA image based
  on the light color. The lighting calculation follows the standard specular
  component of the Phong lighting model. The resulting image depends on the
  light color, light position and surface geometry of the input bump map. The
  result of the lighting calculation is added. The filter primitive assumes
  that the viewer is at infinity in the z direction.

  This filter primitive produces an image which contains the specular reflection
  part of the lighting calculation. Such a map is intended to be combined with
  a texture using the add term of the arithmetic <feComposite> method.
  Multiple light sources can be simulated by adding several of these light
  maps before applying it to the texture image.")

(defelem feSpotLight
  "The <feSpotLight> SVG filter primitive allows to create a spotlight effect.")

(defelem feTile
  "The <feTile> SVG filter primitive allows to fill a target rectangle with a
  repeated, tiled pattern of an input image. The effect is similar to the one
  of a <pattern>.")

(defelem feTurbulence
  "The <feTurbulence> SVG filter primitive creates an image using the Perlin
  turbulence function. It allows the synthesis of artificial textures like
  clouds or marble. The resulting image will fill the entire filter primitive
  subregion.")

(defelem filter
  "The <filter> SVG element serves as container for atomic filter operations.
  It is never rendered directly. A filter is referenced by using the filter
  attribute on the target SVG element or via the filter CSS property.")

(defelem font
  "The <font> SVG element defines a font to be used for text layout.")

(defelem foreignObject
  "The <foreignObject> SVG element allows for inclusion of a foreign XML
  namespace which has its graphical content drawn by a different user agent.
  The included foreign graphical content is subject to SVG transformations and
  compositing.

  The contents of foreignObject are assumed to be from a different namespace.
  Any SVG elements within a foreignObject will not be drawn, except in the
  situation where a properly defined SVG subdocument with a proper xmlns
  attribute specification is embedded recursively. One situation where this
  can occur is when an SVG document fragment is embedded within another
  non-SVG document fragment, which in turn is embedded within an SVG document
  fragment (e.g., an SVG document fragment contains an XHTML document fragment
  which in turn contains yet another SVG document fragment).

  Usually, a foreignObject will be used in conjunction with the <switch>
  element and the requiredExtensions attribute to provide proper checking for
  user agent support and provide an alternate rendering in case user agent
  support is not available.")

(defelem g
  "The <g> SVG element is a container used to group other SVG elements.
  Transformations applied to the <g> element are performed on all of its child
  elements, and any of its attributes are inherited by its child elements. It
  can also group multiple elements to be referenced later with the <use>
  element.")

(defelem glyph
  "A <glyph> defines a single glyph in an SVG font.")

(defelem ^:deprecated glyphRef
  "The glyphRef element provides a single possible glyph to the referencing
  <altGlyph> substitution.")

(defelem ^:experimental hatch
  "The <hatch> SVG element is used to fill or stroke an object using one or
  more pre-defined paths that are repeated at fixed intervals in a specified
  direction to cover the areas to be painted.

  Hatches defined by the <hatch> element can then referenced by the fill and
  stroke CSS properties on a given graphics element to indicate that the given
  element shall be filled or stroked with the hatch. Paths are defined by
  <hatchpath> elements.")

(defelem ^:experimental hatchpath
  "The <hatchpath> SVG element defines a hatch path used by the <hatch>
  element.")

(defelem ^:deprecated hkern
  "The <hkern> SVG element allows to fine-tweak the horizontal distance between
  two glyphs. This process is known as kerning.")


(defelem image
  "The <image> SVG element allows a raster image to be included in an SVG
  document.")

(defelem line
  "The <line> element is an SVG basic shape used to create a line connecting
  two points. Example:

    <svg width=\"120\" height=\"120\" viewPort=\"0 0 120 120\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <line x1=\"20\" y1=\"100\" x2=\"100\" y2=\"20\"
            stroke-width=\"2\" stroke=\"black\"/>
    </svg>")

(defelem linearGradient
  "The <linearGradient> SVG element lets authors define linear gradients to
  fill or stroke graphical elements. Example:

    <svg width=\"120\" height=\"120\" xmlns=\"http://www.w3.org/2000/svg\">
      <defs>
        <linearGradient id=\"MyGradient\">
            <stop offset=\"5%\"  stop-color=\"green\"/>
            <stop offset=\"95%\" stop-color=\"gold\"/>
        </linearGradient>
      </defs>

      <rect fill=\"url(#MyGradient)\"
            x=\"10\" y=\"10\" width=\"100\" height=\"100\"/>
    </svg>")

(defelem marker
  "The <marker> element defines the graphics that is to be used for drawing
  arrowheads or polymarkers on a given <path>, <line>, <polyline> or <polygon>
  element. Example:

    <?xml version=\"1.0\"?>
    <svg width=\"120\" height=\"120\" viewBox=\"0 0 120 120\"
         xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">

      <defs>
        <marker id=\"Triangle\" viewBox=\"0 0 10 10\" refX=\"1\" refY=\"5\"
                markerWidth=\"6\" markerHeight=\"6\" orient=\"auto\">
          <path d=\"M 0 0 L 10 5 L 0 10 z\" />
        </marker>
      </defs>

      <polyline points=\"10,90 50,80 90,20\" fill=\"none\" stroke=\"black\"
                stroke-width=\"2\" marker-end=\"url(#Triangle)\" />
    </svg>")

(defelem mask
  "In SVG, you can specify that any other graphics object or <g> element can be
  used as an alpha mask for compositing the current object into the
  background. A mask is defined with the <mask> element. A mask is
  used/referenced using the mask property.")

(defelem mask
  "TODO")

(defelem meshGradient
  "TODO")

(defelem meshPatch
  "TODO")

(defelm meshRow
  "TODO")

(defelem metadata
  "The <metadata> SVG element allows to add metadata to SVG content. Metadata
  is structured information about data. The contents of <metadata> elements
  should be elements from other XML namespaces such as RDF, FOAF, etc.")

(defelem ^:deprecated missing-glyph
  "The <missing-glyph> SVG element's content is rendered, if for a given
  character the font doesn't define an appropriate <glyph>.")

(defelem mpath
  "The <mpath> sub-element for the <animateMotion> element provides the ability
  to reference an external <path> element as the definition of a motion
  path.")

(defelem path
  "The <path> SVG element is the generic element to define a shape. All the
  basic shapes can be created with a path element. Example:

    <svg width=\"100%\" height=\"100%\" viewBox=\"0 0 400 400\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <path d=\"M 100 100 L 300 100 L 200 300 z\"
            fill=\"orange\" stroke=\"black\" stroke-width=\"3\" />
    </svg>")

(defelem pattern
  "The <pattern> element defines a graphics object which can be redrawn at
  repeated x and y-coordinate intervals (\"tiled\") to cover an area. The
  <pattern> is referenced by the fill and/or stroke attributes on other
  graphics elements to fill or stroke those elements with the referenced
  pattern.")

(defelem polygon
  "The <polygon> element defines a closed shape consisting of a set of
   connected straight line segments. The last point is connected to the first
   point. For open shapes see the <polyline> element. Example:

    <svg width=\"120\" height=\"120\" viewPort=\"0 0 120 120\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <polygon points=\"60,20 100,40 100,80 60,100 20,80 20,40\"/>
    </svg>")

(defelem polyline
  "The <polyline> SVG element is an SVG basic shape that creates straight lines
  connecting several points. Typically a polyline is used to create open
  shapes as the last point doesn't have to be connected to the first point.
  For closed shapes see the <polygon> element.

    <svg width=\"120\" height=\"120\" xmlns=\"http://www.w3.org/2000/svg\">
      <polyline fill=\"none\" stroke=\"black\"
                points=\"20,100 40,60 70,80 100,20\"/>
    </svg>")

(defelem radialGradient
  "The <radialGradient> SVG element lets authors define radial gradients to
  fill or stroke graphical elements. Example:

    <svg width=\"120\" height=\"120\" viewBox=\"0 0 120 120\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <defs>
        <radialGradient id=\"exampleGradient\">
          <stop offset=\"10%\" stop-color=\"gold\"/>
          <stop offset=\"95%\" stop-color=\"green\"/>
        </radialGradient>
      </defs>

      <circle fill=\"url(#exampleGradient)\" cx=\"60\" cy=\"60\" r=\"50\"/>
    </svg>")

(defelem rect
  "The rect element is an SVG basic shape, used to create rectangles based on
  the position of a corner and their width and height. It may also be used to
  create rectangles with rounded corners. Example:

    <svg width=\"120\" height=\"120\" viewBox=\"0 0 120 120\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <rect x=\"10\" y=\"10\" width=\"100\" height=\"100\"/>
    </svg>")

(defelem set
  "The <set> element provides a simple means of just setting the value of an
  attribute for a specified duration. It supports all attribute types,
  including those that cannot reasonably be interpolated, such as string and
  boolean values. The <set> element is non-additive. The additive and
  accumulate attributes are not allowed, and will be ignored if specified.")

(defelem solidColor
  "TODO")

(defelem stop
  "The <stop> SVG element defines the ramp of colors to use on a gradient,
  which is a child element to either the <linearGradient> or the
  <radialGradient> element. Example:

    <svg width=\"100%\" height=\"100%\" viewBox=\"0 0 80 40\"
         xmlns=\"http://www.w3.org/2000/svg\">

      <defs>
        <linearGradient id=\"MyGradient\">
          <stop offset=\"5%\" stop-color=\"#F60\" />
          <stop offset=\"95%\" stop-color=\"#FF6\" />
        </linearGradient>
      </defs>

      <!-- Outline the drawing area in black -->
      <rect fill=\"none\" stroke=\"black\"
            x=\"0.5\" y=\"0.5\" width=\"79\" height=\"39\"/>

      <!-- The rectangle is filled using a linear gradient -->
      <rect fill=\"url(#MyGradient)\" stroke=\"black\" stroke-width=\"1\"
            x=\"10\" y=\"10\" width=\"60\" height=\"20\"/>
    </svg>")


(defelem svg
  "The svg element can be used to embed an SVG fragment inside the current
  document (for example, an HTML document). This SVG fragment has its own
  viewport and coordinate system. Example:

    <!DOCTYPE html>
    <html>
    <head>
      <meta charset=\"UTF-8\" />
      <title>HTML/SVG Example</title>
    </head>

    <body>

      <svg width=\"150\" height=\"100\" viewBox=\"0 0 3 2\">
        <rect width=\"1\" height=\"2\" x=\"0\" fill=\"#008d46\" />
        <rect width=\"1\" height=\"2\" x=\"1\" fill=\"#ffffff\" />
        <rect width=\"1\" height=\"2\" x=\"2\" fill=\"#d2232c\" />
      </svg>

    </body>
    </html>")

(defelem switch
  "The <switch> SVG element evaluates the requiredFeatures, requiredExtensions
  and systemLanguage attributes on its direct child elements in order, and
  then processes and renders the first child for which these attributes
  evaluate to true. All others will be bypassed and therefore not rendered. If
  the child element is a container element such as a <g>, then the entire
  subtree is either processed/rendered or bypassed/not rendered.

  Note that the values of properties display and visibility have no effect on
  switch element processing. In particular, setting display to none on a child
  of a switch element has no effect on true/false testing associated with
  switch element processing.")

(defelem symbol
  "The <symbol> element is used to define graphical template objects which can
  be instantiated by a <use> element. The use of symbol elements for graphics
  that are used multiple times in the same document adds structure and
  semantics. Documents that are rich in structure may be rendered graphically,
  as speech, or as Braille, and thus promote accessibility. Note that a symbol
  element itself is not rendered. Only instances of a symbol element (i.e., a
  reference to a symbol by a <use> element) are rendered.")

(defelem text
  "The SVG <text> element defines a graphics element consisting of text. It's
  possible to apply a gradient, pattern, clipping path, mask, or filter to
  <text>, just like any other SVG graphics element.

  If text is included within SVG not inside of a <text> element, it is not
  rendered. This is different from being hidden by default, as setting the
  display property will not show the text. Example:

    <svg xmlns=\"http://www.w3.org/2000/svg\"
         width=\"500\" height=\"40\" viewBox=\"0 0 500 40\">

      <text x=\"0\" y=\"35\" font-family=\"Verdana\" font-size=\"35\">
        Hello, out there
      </text>
    </svg>")

(defelem textPath
  "In addition to text drawn in a straight line, SVG also includes the ability
  to place text along the shape of a <path> element. To specify that a block
  of text is to be rendered along the shape of a <path>, include the given
  text within a <textPath> element which includes an href attribute with a
  reference to a <path> element. Example:

    <svg viewBox=\"0 0 1000 300\"
         xmlns=\"http://www.w3.org/2000/svg\"
         xmlns:xlink=\"http://www.w3.org/1999/xlink\">
      <defs>
        <path id=\"MyPath\"
              d=\"M 100 200
                 C 200 100 300   0 400 100
                 C 500 200 600 300 700 200
                 C 800 100 900 100 900 100\" />
      </defs>

      <use xlink:href=\"#MyPath\" fill=\"none\" stroke=\"red\"  />

      <text font-family=\"Verdana\" font-size=\"42.5\">
        <textPath xlink:href=\"#MyPath\">
          We go up, then we go down, then up again
        </textPath>
      </text>

      <!-- Show outline of the viewport using 'rect' element -->
      <rect x=\"1\" y=\"1\" width=\"998\" height=\"298\"
            fill=\"none\" stroke=\"black\" stroke-width=\"2\" />
    </svg>")

(defelem title
  "Each container element or graphics element in an SVG drawing can supply a
  <title> element containing a description string where the description is
  text-only. When the current SVG document fragment is rendered as SVG on
  visual media, <title> element is not rendered as part of the graphics.
  However, some user agents may, for example, display the <title> element as a
  tooltip. Alternate presentations are possible, both visual and aural, which
  display the <title> element but do not display path elements or other
  graphics elements. The <title> element generally improve accessibility of
  SVG documents

  Generally <title> element should be the first child element of its parent.
  Note that those implementations that do use <title> to display a tooltip
  often will only do so if the <title> is indeed the first child element of
  its parent.")

(defelem ^:deprecated tref
  "The textual content for a <text> SVG element can be either character data
  directly embedded within the <text> element or the character data content of
  a referenced element, where the referencing is specified with a <tref>
  element.")

(defelem tspan
  "Within a <text> element, text and font properties and the current text
  position can be adjusted with absolute or relative coordinate values by
  including a <tspan> element.")

(defelem unknown
  "TODO")

(defelem use
  "The <use> element takes nodes from within the SVG document, and duplicates
  them somewhere else. The effect is the same as if the nodes were deeply
  cloned into a non-exposed DOM, and then pasted where the use element is,
  much like cloned template elements in HTML5. Since the cloned nodes are not
  exposed, care must be taken when using CSS to style a use element and its
  hidden descendants. CSS attributes are not guaranteed to be inherited by the
  hidden, cloned DOM unless you explicitly request it using CSS inheritance.

  For security reasons, some browsers could apply a same-origin policy on use
  elements and could refuse to load a cross-origin URI within the xlink:href
  attribute.")

(defelem view
  "A view is a defined way to view the image, like a zoom level or a detail
  view. Example:

    <svg width=\"600\" height=\"200\" viewBox=\"0 0 600 200\"
        xmlns=\"http://www.w3.org/2000/svg\"
        xmlns:xlink=\"http://www.w3.org/1999/xlink\">
      <defs>
        <radialGradient id=\"gradient\">
          <stop offset=\"0%\" stop-color=\"#8cffa0\" />
          <stop offset=\"100%\" stop-color=\"#8ca0ff\" />
        </radialGradient>
      </defs>

      <circle r=\"50\" cx=\"180\" cy=\"50\" style=\"fill:url(#gradient)\"/>

      <view id=\"halfSizeView\" viewBox=\"0 0 1200 400\"/>
      <view id=\"normalSizeView\" viewBox=\"0 0 600 200\"/>
      <view id=\"doubleSizeView\" viewBox=\"0 0 300 100\"/>

      <a xlink:href=\"#halfSizeView\">
        <text x=\"5\" y=\"20\" font-size=\"20\">half size</text>
      </a>
      <a xlink:href=\"#normalSizeView\">
        <text x=\"5\" y=\"40\" font-size=\"20\">normal size</text>
      </a>
      <a xlink:href=\"#doubleSizeView\">
        <text x=\"5\" y=\"60\" font-size=\"20\">double size</text>
      </a>
    </svg>")

(defelem ^:deprecated vkern
  "The <vkern> SVG element allows to fine-tweak the vertical distance between
  two glyphs in top-to-bottom fonts. This process is known as kerning.")