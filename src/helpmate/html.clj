(ns helpmate.html
  "Content derived from Mozilla Developer Network and individual contributors,
  under the terms of the Creative Commons Attribution-ShareAlike license (CC-BY-SA), v2.5"
  (:refer-clojure :exclude [meta map time var])
  (:require
   [helpmate.core :refer [defelem]]))

(defelem a
  "The HTML Anchor Element (<a>) defines a hyperlink to a location on the same
  page or any other page on the Web. It can also be used (in an obsolete way)
  to create an anchor point—a destination for hyperlinks within the content of
  a page, so that links aren't limited to connecting simply to the top of a
  page.")

(defelem abbr
  "The HTML <abbr> element (or HTML Abbreviation Element) represents an
  abbreviation and optionally provides a full description for it. If present,
  the title attribute must contain this full description and nothing else.
  Example:

    <p>I do <abbr title=\"Hypertext Markup Language\">HTML</abbr></p>")

(defelem ^:deprecated acronym
  "The HTML Acronym Element (<acronym>) allows authors to clearly indicate a
  sequence of characters that compose an acronym or abbreviation for a word.
  This feature is obsolete. Although it may still work in some browsers, its
  use is discouraged since it could be removed at any time. Try to avoid using
  it. This element has been removed in HTML5.  Use <abbr> element.")

(defelem address
  "The HTML <address> element supplies contact information for its nearest
  <article> or <body> ancestor; in the latter case, it applies to the whole
  document.

    * To represent an arbitrary address, one that is not related to the
      contact information, use a <p> element rather than the <address>
      element.

    * This element should not contain more information than the contact
      information, like a publication date (which belongs in a <time>
      element).

    * Typically an <address> element can be placed inside the <footer>
      element of the current section, if any.")

(defelem ^:deprecated applet
  "The <applet> tag defines an embedded applet. Note: There is still some
  support for the <applet> tag in some browsers, but it requires additional
  plug-ins/installations to work. The <applet> tag is not supported in HTML5.
  Use <embed> or <object> instead.")

(defelem area
  "The HTML <area> element defines a hot-spot region on an image, and
  optionally associates it with a hypertext link. This element is used only
  within a <map> element.")

(defelem article
  "[HTML5] The HTML <article> element represents a self-contained composition
  in a document, page, application, or site, which is intended to be
  independently distributable or reusable (e.g., in syndication). This could
  be a forum post, a magazine or newspaper article, a blog entry, an object,
  or any other independent item of content. Each <article> should be
  identified, typically by including a heading (<h1>-<h6> element) as a child
  of the <article> element.

    * When an <article> element is nested, the inner element represents an
      article related to the outer element. For example, the comments of a
      blog post can be <article> elements nested in the <article> representing
      the blog post.

    * Author information of an <article> element can be provided through the
      <address> element, but it doesn't apply to nested <article> elements.

    * The publication date and time of an <article> element can be described
      using the datetime attribute of a <time> element. Note that the pubdate
      attribute of <time> is no longer a part of the W3C HTML 5 standard.")

(defelem aside
  "[HTML5] The HTML <aside> element represents a section of the page with
  content connected tangentially to the rest, which could be considered
  separate from that content. These sections are often represented as sidebars
  or inserts. They often contain the definitions on the sidebars, such as
  definitions from the glossary; there may also be other types of information,
  such as related advertisements; the biography of the author; web
  applications; profile information or related links on the blog.

    * Do not use the <aside> element to tag parenthesized text, as this kind
      of text is considered part of the main flow.")

(defelem audio
  "[HTML5] The HTML <audio> element is used to embed sound content in
  documents. It may contain one or more audio sources, represented using the
  src attribute or the <source> element; the browser will choose the most
  suitable one. Fallback content for browsers not supporting the <audio>
  element can be added too, inside the opening and closing <audio></audio>
  tags.

  The most basic playback functionality can be made available using the
  controls attribute (see below); for more advanced usage, audio playback and
  controls can be manipulated using the HTML Media API, and more specifically
  the features defined in the HTMLAudioElement interface. You can also use
  the Web Audio API to directly generate and manipulate audio streams from
  JavaScript code. See Web Audio API for details.

    * Permitted content: If the element has a src attribute: zero or more
      <track> elements, followed by transparent content that contains no
      media elements — that is, no <audio> or <video> elements.

    * Else: zero or more <source> elements, followed by zero or more
      <track> elements, followed by transparent content that contains no
      media elements, that is no <audio> or <video> elements.

  Currently, there are 3 supported file formats for the <audio> element: MP3,
  Wav, and Ogg, with the following MIME types respectively: audio/mpeg,
  audio/wav and audio/wav.")

(defelem b
  "The HTML <b> Element represents a span of text stylistically different from
  normal text, without conveying any special importance or relevance. It is
  typically used for keywords in a summary, product names in a review, or
  other spans of text whose typical presentation would be boldfaced. Another
  example of its use is to mark the lead sentence of each paragraph of an
  article.

    * Do not confuse the <b> element with the <strong>, <em>, or <mark>
      elements. The <strong> element represents text of certain importance,
      <em> puts some emphasis on the text and the <mark> element represents
      text of certain relevance. The <b> element doesn't convey such special
      semantic information; use it only when no others fit.

    * Similarly, do not mark titles and headings using the <b> element. For
      this purpose, use the <h1> to <h6> tags. Further, stylesheets can change
      the default style of these elements, with the result that they are not
      necessarily displayed in bold.

    * It is a good practice to use the class attribute on the <b> in order to
      convey additional semantic information (for example <b class=\"lead\">
      for the first sentence in a paragraph). This eases the development of
      several stylings of a web document, without the need to change its HTML
      code.

    * Historically, the <b> element was meant to make text boldface. Styling
      information has been deprecated since HTML4, so the meaning of the <b>
      element has been changed.

    * If there is no semantic purpose on using the <b> element, using css
      property font-weight with bold value would be a better choice for
      making text bold.")

(defelem base
  "The HTML <base> element specifies the base URL to use for all relative URLs
  contained within a document. There can be only one <base> element in a
  document. The base URL of a document can be queried from a script using
  document.baseURI. Note: If multiple <base> elements are specified, only the
  first href and first target value are used; all others are ignored.")

(defelem ^:deprecated basefont
  "The HTML basefont element (<basefont>) establishes a default font size for a
  document. Font size then can be varied relative to the base font size using
  the <font> element.

  Do not use this element! Though once (imprecisely) normalized in HTML 3.2, it
  wasn't supported in all major browsers. Further, browsers, and even
  successive versions of browsers, never implemented it in the same way:
  practically, using it has always brought indeterminate results.

  The <basefont> element was deprecated in the standard at the same time as all
  elements related to styling only. Starting with HTML 4, HTML does not convey
  styling information anymore (outside the <style> element or the style
  attribute of each element). In HTML5, this element has been removed
  completely. For any new web development, styling should be written using CSS
  only.

  The former behavior of the <font> element can be achieved, and even better
  controlled using the CSS Fonts properties.")

(defelem bdi
  "[HTML5] The HTML <bdi> Element (or Bi-Directional Isolation Element)
  isolates a span of text that might be formatted in a different direction
  from other text outside it. This element is useful when embedding text with
  an unknown directionality, from a database for example, inside text with a
  fixed directionality.

  Though the same visual effect can be achieved using the CSS rule
  unicode-bidi: isolate on a <span> or another text-formatting element, the
  semantic meaning is only conveyed by the <bdi> element.  Especially,
  browsers are allowed to ignore CSS styling. In such a case, the text would
  still be correctly displayed using the HTML element, but will become garbage
  when using the CSS styling to convey semantic.")

(defelem bdo
  "The HTML <bdo> Element (or HTML bidirectional override element) is used to
  override the current directionality of text. It causes the directionality of
  the characters to be ignored in favor of the specified directionality.")

(defelem ^:deprecated big
  "The HTML Big Element (<big>) makes the text font size one size bigger (for
  example, from small to medium, or from large to x-large) up to the browser's
  maximum font size. Note: As it was purely presentational, this element has
  been removed in HTML5 and shouldn't be used anymore. Instead web developers
  should use CSS properties.")

(defelem blockquote
  "The HTML <blockquote> Element (or HTML Block Quotation Element) indicates
  that the enclosed text is an extended quotation. Usually, this is rendered
  visually by indentation (see Notes for how to change it). A URL for the
  source of the quotation may be given using the cite attribute, while a text
  representation of the source can be given using the <cite> element. Example:

    <blockquote cite=\"http://www.worldwildlife.org/who/index.html\">
      For 50 years, WWF has been protecting the future of nature. The
      world's leading conservation organization, WWF works in 100
      countries and is supported by 1.2 million members in the United
      States and close to 5 million globally.
    </blockquote>")

(defelem body
  "The HTML <body> Element represents the content of an HTML document. There
  can be only one <body> element in a document. All layout attributes are
  removed in HTML5.")

(defelem ^:empty-tag br
  "The HTML element line break <br> produces a line break in text
  (carriage-return). It is useful for writing a poem or an address, where the
  division of lines is significant.  Do not use <br> to increase the gap
  between lines of text; use the CSS margin property or the <p> element.")

(defelem button
  "The HTML <button> Element represents a clickable button. Inside a <button>
  element you can put content, like text or images. This is the difference
  between this element and buttons created with the <input> element. Always
  specify the type attribute for a <button> element. Different browsers use
  different default types for the <button> element. Note: If you use the
  <button> element in an HTML form, different browsers may submit different
  values. Use <input> to create buttons in an HTML form.")

(defelem canvas
  "[HTML5] The HTML <canvas> Element can be used to draw graphics via scripting
  (usually JavaScript). For example, it can be used to draw graphs, make photo
  compositions or even perform animations. You may (and should) provide
  alternate content inside the <canvas> block. That content will be rendered
  both on older browsers that don't support canvas and in browsers with
  JavaScript disabled.")

(defelem caption
  "The HTML <caption> Element (or HTML Table Caption Element) represents the
  title of a table. Though it is always the first descendant of a <table>, its
  styling, using CSS, may place it elsewhere, relative to the table. Note:
  When the <table> element that is the parent of this <caption> is the only
  descendant of a <figure> element, use the <figcaption> element instead.
  Example:

    <table>
      <caption>Monthly savings</caption>
      <tr>
        <th>Month</th>
        <th>Savings</th>
      </tr>
      <tr>
        <td>January</td>
        <td>$100</td>
      </tr>
    </table>")

(defelem ^:deprecated center
  "The HTML Center Element (<center>) is a block-level element that can contain
  paragraphs and other block-level and inline elements. The entire content of
  this element is centered horizontally within its containing element
  (typically, the <body>).

  This tag has been deprecated in HTML 4 (and XHTML 1) in favor of the CSS
  text-align property, which can be applied to the <div> element or to an
  individual <p>. For centering blocks, use other CSS properties like
  margin-left and margin-right and set them to auto (or set margin to 0
  auto).")

(defelem cite
  "The HTML Citation Element (<cite>) represents a reference to a creative
  work. It must include the title of a work or a URL reference, which may be
  in an abbreviated form according to the conventions used for the addition of
  citation metadata.

    * A creative work may include a book, a paper, an essay, a poem, a score,
      a song, a script, a film, a TV show, a game, a sculpture, a painting, a
      theater production, a play, an opera, a musical, an exhibition, a legal
      case report, a computer program, a web site, a web page, a blog post or
      comment, a forum post or comment, a tweet, a written or oral statement,
      etc.

    * The W3C spec states that a reference to a creative work may include the
      author's name, while WHATWG has declared that it may not include a
      person's name under any circumstances.

    * Use the cite attribute on a <blockquote> or <q> element to reference an
      online resource for a source.")

(defelem code
  "The HTML Code Element (<code>) represents a fragment of computer code. By
  default, it is displayed in the browser's default monospace font. This tag
  is not deprecated, but it is possible to achieve richer effect with CSS.")

(defelem col
  "The HTML Table Column Element (<col>) defines a column within a table and is
  used for defining common semantics on all common cells. It is generally
  found within a <colgroup> element. This element allows styling columns using
  CSS, but only a few attributes will have an effect on the column (see the
  CSS 2.1 specification for a list).")

(defelem colgroup
  "The HTML Table Column Group Element (<colgroup>) defines a group of columns
  within a table for formatting. The <colgroup> tag is useful for applying
  styles to entire columns, instead of repeating the styles for each cell, for
  each row. Note: The <colgroup> tag must be a child of a <table> element,
  after any <caption> elements and before any <thead>, <tbody>, <tfoot>, and
  <tr> elements. To define different properties to a column within a
  <colgroup>, use the <col> tag within the <colgroup> tag. Example:

    <table>
      <colgroup>
        <col span=\"2\" style=\"background-color:red\">
        <col style=\"background-color:yellow\">
      </colgroup>
      <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
      </tr>
      <tr>
        <td>3476896</td>
        <td>My first HTML</td>
        <td>$53</td>
      </tr>
    </table>")

(defelem data
  "The HTML <data> Element links a given content with a machine-readable
  translation. If the content is time- or date-related, the <time> must be
  used.")

(defelem datalist
  "[HTML5] The <datalist> tag specifies a list of pre-defined options for an
  <input> element. The <datalist> tag is used to provide an \"autocomplete\"
  feature on <input> elements. Users will see a drop-down list of pre-defined
  options as they input data. Use the <input> element's list attribute to
  bind it together with a <datalist> element. Example:

    <input list=\"browsers\">

    <datalist id=\"browsers\">
      <option value=\"Internet Explorer\">
      <option value=\"Firefox\">
      <option value=\"Chrome\">
      <option value=\"Opera\">
      <option value=\"Safari\">
    </datalist>")

(defelem dd
  "The HTML <dd> element (HTML Description Element) indicates the description
  of a term in a description list (<dl>) element. This element can occur only
  as a child element of a description list and it must follow a <dt> element.
  Example:

    <dl>
      <dt>Coffee</dt>
      <dd>Black hot drink</dd>
      <dt>Milk</dt>
      <dd>White cold drink</dd>
    </dl>")

(defelem del
  "The HTML Deleted Text Element (<del>) represents a range of text that has
  been deleted from a document. This element is often (but need not be)
  rendered with strike-through text.")

(defelem details
  "[HTML5] The <details> tag specifies additional details that the user can
  view or hide on demand. The <details> tag can be used to create an
  interactive widget that the user can open and close. Any sort of content can
  be put inside the <details> tag. The content of a <details> element should
  not be visible unless the open attribute is set. Example:

    <details>
      <summary>Some details</summary>
      <p>More info about the details.</p>
    </details>

  The <summary> tag is used to specify a visible heading for the details.
  The heading can be clicked to view/hide the details.")

(defelem dfn
  "[HTML5] The HTML Definition Element (<dfn>) represents the defining instance
   of a term.

     * The <dfn> element marks the term being defined; the definition of the
       term should be given by the surrounding <p>, <section> or definition
       list group (usually a <dt>, <dd> pair).

     * The exact value of the term being defined is determined by the
       following rules:
       - If the <dfn> element has a title attribute, then the term is the
         value of that attribute.
       - Else, if it contains only an <abbr> element with a title attribute,
         then the term is the value of that attribute.
       - Otherwise, the text content of the <dfn> element is the term being
         defined.")

(defelem ^:experimental dialog
  "[Experimental] The HTML <dialog> element represents a dialog box or other
  interactive component, such as an inspector or window. <form> elements can
  be integrated within a dialog by specifying them with the attribute
  method=\"dialog\". When such a form is submitted, the dialog is closed with
  a returnValue attribute set to the value of the submit button used.

  The ::backdrop CSS pseudo-element can be used to style behind a <dialog>
  element, for example to dim inaccessible content whilst a modal dialog is
  active.")

(defelem ^:deprecated dir
  "The HTML directory element (<dir>) represents a directory, namely a
  collection of filenames. Note: Do not use this element. Though present in
  the early HTML specification, it has been deprecated in HTML 4, then is
  obsolete in HTML5. Use the <ul> instead.")

(defelem ^:non-void div
  "The HTML <div> element (or HTML Document Division Element) is the generic
  container for flow content, which does not inherently represent anything. It
  can be used to group elements for styling purposes (using the class or id
  attributes), or because they share attribute values, such as lang. It should
  be used only when no other semantic element (such as <article> or <nav>) is
  appropriate.")

(defelem dl
  "The HTML <dl> element (or HTML Description List Element) encloses a list of
  pairs of terms and descriptions. Common uses for this element are to
  implement a glossary or to display metadata (a list of key-value pairs).
  Prior to HTML5, <dl> was known as a Definition List.")

(defelem dt
  "The HTML <dt> element (or HTML Definition Term Element) identifies a term in
  a definition list. This element can occur only as a child element of a <dl>.
  It is usually followed by a <dd> element; however, multiple <dt> elements in
  a row indicate several terms that are all defined by the immediate next <dd>
  element.")

(defelem ^:deprecated element
  "The HTML <element> element is used to define new custom DOM elements.
  Note: This tag has been removed from the specification. See this for more
  information from the editor of the specification.")

(defelem em
  "The HTML element emphasis  <em> marks text that has stress emphasis. The
  <em> element can be nested, with each level of nesting indicating a greater
  degree of emphasis. Note: Typically this element is displayed in italic
  type. However, it should not be used simply to apply italic styling; use the
  CSS styling for that purpose. Use the <cite> element to mark the title of a
  work (book, play, song, etc.); it is also typically styled with italic type,
  but carries different meaning. Use the <strong> element to mark text that
  has greater importance than surrounding text.")

(defelem embed
  "The HTML <embed> Element represents an integration point for an external
  application or interactive content (in other words, a plug-in). See other
  elements that are used for embedding content of various types include
  <audio>, <canvas>, <iframe>, <img>, <math>, <object>, <svg>, and <video>.")

(defelem fieldset
  "The HTML <fieldset> element is used to group several controls as well as
  labels (<label>) within a web form. Note: unlike almost any other element,
  the WHATWG HTML Rendering spec suggests min-width: min-content as part of
  the default style for <fieldset>, and many browsers implement such styling
  (or something that approximates it). Example:

    <form action=\"test.php\" method=\"post\">
      <fieldset>
        <legend>Title</legend>
        <input type=\"radio\" id=\"radio\"> <label for=\"radio\">Click me</label>
      </fieldset>
    </form>")

(defelem figcaption
  "The HTML <figcaption> element represents a caption or a legend associated
  with a figure or an illustration described by the rest of the data of the
  <figure> element which is its immediate ancestor which means <figcaption>
  can be the first or last element inside a <figure> block. Also, the HTML
  Figcaption Element is optional; if not provided, then the parent figure
  element will have no caption.")

(defelem figure
  "The HTML <figure> element represents self-contained content, frequently with
  a caption (<figcaption>), and is typically referenced as a single unit.
  While it is related to the main flow, its position is independent of the
  main flow. Usually this is an image, an illustration, a diagram, a code
  snippet, or a schema that is referenced in the main text, but that can be
  moved to another page or to an appendix without affecting the main flow.

    * Being a sectioning root, the outline of the content of the <figure>
      element is excluded from the main outline of the document.

    * A caption can be associated with the <figure> element by inserting
      a <figcaption> inside it (as the first or the last child).

  Example:

    <figure>
      <img src=\"https://developer.cdn.mozilla.net/media/img/mdn-logo-sm.png\"
           alt=\"An awesome picture\">
      <figcaption>Fig1. MDN Logo</figcaption>
    </figure>")

(defelem ^:deprecated font
  "The HTML Font Element (<font>) defines the font size, color and face for its
  content. Do not use this element! Though once normalized in HTML 3.2, it
  was deprecated in HTML 4.01, at the same time as all elements related to
  styling only, then obsoleted in HTML5.  Starting with HTML 4, HTML does not
  convey styling information anymore (outside the <style> element or the style
  attribute of each element). For any new web development, styling should be
  written using CSS only. The former behavior of the <font> element can be
  achieved, and even better controlled using the CSS Fonts CSS properties.")

(defelem footer
  "The HTML <footer> element represents a footer for its nearest sectioning
  content or sectioning root element. A footer typically contains information
  about the author of the section, copyright data or links to related
  documents. Notes: Enclose information about the author in an <address>
  element that can be included into the <footer> element.  The <footer>
  element is not sectioning content and therefore doesn't introduce a new
  section in the outline.")

(defelem form
  "The HTML <form> element represents a document section that contains
  interactive controls to submit information to a web server. It is possible
  to use the :valid and :invalid CSS pseudo-classes to style a <form>
  element. Example:

    <form action=\"\" method=\"post\">
      <fieldset>
        <legend>Title</legend>
        <input type=\"radio\" id=\"radio\">
        <label for=\"radio\">Click me</label>
      </fieldset>
    </form>")

(defelem ^:deprecated frame
  "<frame> is an HTML element which defines a particular area in which another
  HTML document can be displayed. A frame should be used within a <frameset>.
  Using the <frame> element is not encouraged because of certain disadvantages
  such as performance problems and lack of accessibility for users with screen
  readers. Instead of the <frame> element, <iframe> may be preferred.")

(defelem ^:deprecated frameset
  "<frameset> is an HTML element which is used to contain <frame> elements.
  Note: Because the use of frames is now discouraged in favor of using
  <iframe>, this element is not typically used by modern web sites.")

(defelem head
  "The HTML <head> element provides general information (metadata) about the
  document, including its title and links to its scripts and style sheets.
  Modern, HTML5-compliant browsers automatically construct a <head> element if
  the tags are omitted in the markup. This behavior cannot be guaranteed in
  ancient browsers.")

(defelem header
  "The HTML <header> element represents a group of introductory or navigational
  aids. It may contain some heading elements but also other elements like a
  logo, wrapped section's header, a search form, and so on. Note: The <header>
  element is not sectioning content and therefore doesn't introduce a new
  section in the outline. Example:

    <header>
      <h1>Main Page Title</h1>
      <img src=\"mdn-logo-sm.png\" alt=\"MDN logo\">
    </header>")

(defelem ^:empty-tag hr
  "The HTML <hr> element represents a thematic break between paragraph-level
  elements (for example, a change of scene in a story, or a shift of topic
  with a section). In previous versions of HTML, it represented a horizontal
  rule. It may still be displayed as a horizontal rule in visual browsers, but
  is now defined in semantic terms, rather than presentational terms. To
  change look of rule or gaps between it and paragraphs, use Cascading Style
  Sheets (CSS).")

(defelem html
  "The HTML <html> element (or HTML root element) represents the root of an
  HTML document. All other elements must be descendants of this element. Since
  the <html> element is the first in a document other than comments, it is
  called the root element. Although this tag can be implied, or not required,
  with HTML, it is required to be opened and closed in XHTML.")

(defelem i
  "The HTML <i> Element represents a range of text that is set off from the
  normal text for some reason, for example, technical terms, foreign language
  phrases, or fictional character thoughts. It is typically displayed in
  italic type.")

(defelem iframe
  "The HTML Inline Frame Element (<iframe>) represents a nested browsing
  context, effectively embedding another HTML page into the current page.
  In HTML 4.01, a document may contain a head and a body or a head and a
  frameset, but not both a body and a frameset. However, an <iframe> can
  be used within a normal document body. Each browsing context has its own
  session history and active document. The browsing context that contains
  the embedded content is called the parent browsing context. The top-level
  browsing context (which has no parent) is typically the browser window.")

(defelem ^:empty-tag img
  "The HTML <img> element represents an image in the document. Note: Browsers
  do not always display the image referenced by the element. This is the case
  for non-graphical browsers (including those used by people with vision
  impairments), if the user chooses not to display images, or if the browser
  cannot display the image because it is invalid or an unsupported type. In
  these cases, the browser may replace the image with the text defined in this
  element's alt attribute.")

(defelem input
  "The HTML element <input> is used to create interactive controls for
  web-based forms in order to accept data from the user. How an <input> works
  varies considerably depending on the value of its type attribute.")

(defelem ins
  "The HTML <ins> Element (or HTML Inserted Text) HTML represents a range of
  text that has been added to a document.")

(defelem kbd
  "The HTML Keyboard Input Element (<kbd>) represents user input and produces
  an inline element displayed in the browser's default monospace font.")

(defelem label
  "The HTML Label Element (<label>) represents a caption for an item in a user
  interface. It can be associated with a control either by placing the control
  element inside the <label> element, or by using the for attribute. Such a
  control is called the labeled control of the label element. One input can be
  associated with multiple labels.

  It's worth noting, however, that labels are not themselves directly
  associated with forms. They are only indirectly associated with forms
  through the controls with which they're associated.

  Prior to a revision to the HTML specification made on April 28, 2016, the
  <label> element's form attribute allowed directly associating labels with
  forms.")

(defelem legend
  "The HTML <legend> Element (or HTML Legend Field Element) represents a
  caption for the content of its parent <fieldset>.")

(defelem li
  "The HTML <li> element (or HTML List Item Element) is used to represent an
  item in a list. It must be contained in a parent element: an ordered list
  (<ol>), an unordered list (<ul>), or a menu (<menu>). In menus and unordered
  lists, list items are usually displayed using bullet points. In ordered
  lists, they are usually displayed with an ascending counter on the left,
  such as a number or letter.")

(defelem ^:empty-tag link
  "The HTML <link> element specifies relationships between the current document
  and an external resource. Possible uses for this element include defining a
  relational framework for navigation. This Element is most used to link to
  style sheets.")

(defelem main
  "The HTML <main> element represents the main content of the <body> of a
  document or application. The main content area consists of content that is
  directly related to, or expands upon the central topic of a document or the
  central functionality of an application. This content should be unique to
  the document, excluding any content that is repeated across a set of
  documents such as sidebars, navigation links, copyright information, site
  logos, and search forms (unless the document's main function is as a search
  form).

  Note: <main> must not be a descendent of an <article>, <aside>, <footer>,
  <header>, or <nav> element. Only one main element can be used per
  document.")

(defelem map
  "The HTML <map> element is used with <area> elements to define an image map
  (a clickable link area).")

(defelem mark
  "The HTML Mark Element (<mark>) represents highlighted text, i.e., a run of
  text marked for reference purpose, due to its relevance in a particular
  context. For example it can be used in a page showing search results to
  highlight every instance of the searched-for word.

    * In a quotation or another block, the highlighted text typically marks
      text that is referenced outside the quote, or marked for specific
      scrutiny even though the original author didn't consider it important.

    * In the main text, the highlighted text typically marks text that may
      be of special relevance for the user's current activity, like search
      results.

    * Do not use the <mark> element for syntax highlighting; use the <span>
      element for this purpose.

    * Do not confuse the <mark> element with the <strong> element. The
      <strong> element is used to denote spans of text of importance in
      context of the text, when the <mark> element is used to denote spans
      of text of relevance to a different context.")

(defelem ^:experimental menu
  "[Experimental] The HTML <menu> element represents a group of commands that a
  user can perform or activate. This includes both list menus, which might
  appear across the top of a screen, as well as context menus, such as those
  that might appear underneath a button after it has been clicked. Note: The
  <menu> and <ul> elements both represent an unordered list of items. The key
  difference is that <ul> primarily contains items for display, whilst <menu>
  is intended for interactive items, to act on.")

(defelem ^:experimental menuitem
  "[Experimental] The HTML <menuitem> element represents a command that a user
  is able to invoke through a popup menu. This includes context menus, as well
  as menus that might be attached to a menu button.

  A command can either be defined explicitly, with a textual label and optional
  icon to describe its appearance, or alternatively as an indirect command
  whose behavior is defined by a separate element. Commands can also
  optionally include a checkbox or be grouped to share radio buttons. (Menu
  items for indirect commands gain checkboxes or radio buttons when defined
  against elements <input type=\"checkbox\"> and <input type=\"radio\">.)")

(defelem ^:empty-tag meta
  "The HTML <meta> element represents any metadata information that cannot be
  represented by one of the other HTML meta-related elements (<base>, <link>,
  <script>, <style> or <title>).

  Depending on the attributes set, the kind of metadata can be one of the
  following:

    * If name is set, it is document-level metadata, applying to the whole
      page.

    * If http-equiv is set, it is a pragma directive, i.e. information
      normally given by the web server about how the web page should be served.

    * If charset is set, it is a charset declaration, i.e. the charset used for
      the serialized form of the webpage.

    * If itemprop is set, it is user-defined metadata, transparent for the
      user-agent as the semantics of the metadata is user-specific.")

(defelem meter
  "[HTML5] The HTML <meter> Element represents either a scalar value within a
   known range or a fractional value. Note: Unless the value attribute is
   between 0 and 1 (inclusive), the min and max attributes should define the
   range so that the value attribute's value is within it. Example:

     <p>
       Heat the oven to
       <meter min=\"200\" max=\"500\" value=\"350\">
         350 degrees
       </meter>.
     </p>")

(defelem nav
  "The HTML <nav> element (HTML Navigation Element) represents a section of a
  page that links to other pages or to parts within the page: a section with
  navigation links.

    * Not all links of a document must be in a <nav> element, which is
      intended only for major block of navigation links; typically the
      <footer> element often has a list of links that don't need to be
      in a <nav> element.

    * A document may have several <nav> elements, for example, one for
      site navigation and one for intra-page navigation.

    * User agents, such as screen readers targeting disabled users, can
      use this element to determine whether to omit the initial rendering
      of this content.")

(defelem ^:deprecated noframes
  "<noframes> is an HTML element which is used to supporting browsers which are
  not able to support <frame> elements or configured to do so. You can use any
  HTML element inside of <noframes> which are expected to be seen inside of
  <body> element, except <frameset> and <frame> elements. Note: Because of the
  fact that all mainstream browsers support frames, usage of this element is
  not necessary in general cases. It is also entirely obsolete in HTML5 and
  should be avoided to conform to the standard.")

(defelem noscript
  "The HTML <noscript> Element defines a section of html to be inserted if a
  script type on the page is unsupported or if scripting is currently turned
  off in the browser.")

(defelem object
  "The HTML Embedded Object Element (<object>) represents an external resource,
  which can be treated as an image, a nested browsing context, or a resource
  to be handled by a plugin.")

(defelem ol
  "The HTML <ol> Element (or HTML Ordered List Element) represents an ordered
  list of items. Typically, ordered-list items are displayed with a preceding
  numbering, which can be of any form, like numerals, letters or Romans
  numerals or even simple bullets. This numbered style is not defined in the
  HTML description of the page, but in its associated CSS, using the
  list-style-type property.

  There is no limitation to the depth and overlap of lists defined with the
  <ol> and <ul> elements.

  Note: The <ol> and <ul> both represent a list of items. They differ in the
  way that, with the <ol> element, the order is meaningful. As a rule of thumb
  to determine which one to use, try changing the order of the list items; if
  the meaning is changed, the <ol> element should be used, else the <ul> is
  adequate.")

(defelem optgroup
  "In a Web form, the HTML <optgroup> element creates a grouping of options
  within a <select> element. Example:

    <select>
      <optgroup label=\"Group 1\">
        <option>Option 1.1</option>
      </optgroup>
      <optgroup label=\"Group 2\">
        <option>Option 2.1</option>
        <option>Option 2.2</option>
      </optgroup>
      <optgroup label=\"Group 3\" disabled>
        <option>Option 3.1</option>
        <option>Option 3.2</option>
        <option>Option 3.3</option>
      </optgroup>
    </select>")

(defelem option
  "In a Web form, the HTML <option> element is used to create a control
  representing an item within a <select>, an <optgroup> or a <datalist> HTML5
  element.")

(defelem output
  "The HTML <output> element represents the result of a calculation or user
  action. Example:

    <form oninput=\"result.value=parseInt(a.value)+parseInt(b.value)\">
      <input type=\"range\" name=\"b\" value=\"50\" /> +
      <input type=\"number\" name=\"a\" value=\"10\" /> =
      <output name=\"result\">60</output>
    </form>")

(defelem p
  "The HTML <p> element (or HTML Paragraph Element) represents a paragraph of
  text. Paragraphs are usually represented in visual media as blocks of text
  that are separated from adjacent blocks by vertical blank space and/or
  first-line indentation. The paragraph must be closed at end of the text
  \"<p> text </p>\" are requried to put the text between the paragraph.
  Paragraphs are block-level elements. Note: To change gaps between
  paragraphs, use the CSS margin property. Do not insert empty paragraphs
  elements or <br> between them.")

(defelem param
  "The HTML <param> Element (or HTML Parameter Element) defines parameters
  for <object>.")

(defelem pre
  "The HTML <pre> element (or HTML Preformatted Text) represents preformatted
  text. Text within this element is typically displayed in a non-proportional
   (\"monospace\") font exactly as it is laid out in the file. Whitespace
  inside this element is displayed as typed. Note: you will need to escape any
  contained '<' characters as '&lt;' to make sure enclosed code is not
  interpreted as markup.")

(defelem progress
  "[HTML5] The HTML <progress> Element is used to view the completion progress
  of a task. While the specifics of how it's displayed is left up to the
  browser developer, it's typically displayed as a progress bar. Javascript
  can be used to manipulate the value of progress bar. Example:

    <progress value=\"70\" max=\"100\">70 %</progress>")

(defelem q
  "The HTML Quote Element (<q>) indicates that the enclosed text is a short
  inline quotation. This element is intended for short quotations that don't
  require paragraph breaks; for long quotations use <blockquote> element.
  Note: Most modern standards-aware browsers, like Mozilla Firefox, Opera, and
  Safari, should add quotes around text enclosed within the <q> element.  Some
  browsers, like Internet Explorer, may not make any sort of style change for
  quotations, but it is possible to apply a style rule. Example:

    <p>Everytime Kenny is killed, Stan will announce
      <q cite=\"http://en.wikipedia.org/wiki/Kenny_McCormick#Cultural_impact\">
        Oh my God, you/they killed Kenny!
      </q>.
    </p>")

(defelem rp
  "The HTML <rp> element is used to provide fall-back parenthesis for browsers
  non-supporting ruby annotations. Ruby annotations are for showing
  pronunciation of East Asian characters, like using Japanese furigana or
  Taiwainese bopomofo characters. The <rp> element is used in the case of lack
  of <ruby> element support its content has what should be displayed in order
  to indicate the presence of a ruby annotation, usually parentheses.")

(defelem rt
  "The HTML <rt> Element embraces pronunciation of characters presented in a
  ruby annotations, which are used to describe the pronunciation of East Asian
  characters. This element is always used inside a <ruby> element.")

(defelem rtc
  "The HTML <rtc> Element embraces semantic annotations of characters presented
  in a ruby of <rb> elements used inside of <ruby> element. <rb> elements can
  have both pronunciation (<rt>) and semantic (<rtc>) annotations.")

(defelem ruby
  "The HTML <ruby> Element represents a ruby annotation. Ruby annotations are
  for showing pronunciation of East Asian characters. Example:

    <ruby>
      漢 <rp>(</rp><rt>Kan</rt><rp>)</rp>
      字 <rp>(</rp><rt>ji</rt><rp>)</rp>
    </ruby>")

(defelem s
  "The HTML Strikethrough Element (<s>) renders text with a strikethrough, or a
  line through it. Use the <s> element to represent things that are no longer
  relevant or no longer accurate. However, <s> is not appropriate when
  indicating document edits; for that, use the <del> and <ins> elements, as
  appropriate.")

(defelem samp
  "The HTML <samp> element is an element intended to identify sample output
  from a computer program. It is usually displayed in the browser's default
  monotype font (such as Lucida Console).")

(defelem ^:non-void script
  "The HTML Script Element (<script>) is used to embed or reference an
  executable script within an HTML or XHTML document. Scripts without async or
  defer attributes, as well as inline scripts, are fetched and executed
  immediately, before the browser continues to parse the page.")

(defelem section
  "The HTML <section> element represents a generic section of a document, i.e.,
  a thematic grouping of content, typically with a heading. Each <section>
  should be identified, typically by including a heading (<h1>-<h6> element)
  as a child of the <section> element.

    * If it makes sense to separately syndicate the content of a <section>
      element, use an <article> element instead.

    * Do not use the <section> element as a generic container; this is what
      <div> is for, especially when the sectioning is only for styling
      purposes. A rule of thumb is that a section should logically appear
      in the outline of a document.")

(defelem select
  "The HTML select (<select>) element represents a control that presents a menu
  of options. The options within the menu are represented by <option>
  elements, which can be grouped by <optgroup> elements. Options can be
  pre-selected for the user.")

(defelem ^:experimental shadow
  "The HTML <shadow> element is used as a shadow DOM insertion point. You might
  use it if you have created multiple shadow roots under a shadow host. It is
  not useful in ordinary HTML. It is used with Web Components.")

(defelem small
  "The HTML Small Element (<small>) makes the text font size one size smaller
  (for example, from large to medium, or from small to x-small) down to the
  browser's minimum font size.  In HTML5, this element is repurposed to
  represent side-comments and small print, including copyright and legal text,
  independent of its styled presentation.")

(defelem source
  "The HTML <source> element specifies multiple media resources for either the
  <picture>, the <audio> or the <video> element. It is an empty element. It is
  commonly used to serve the same media content in multiple formats supported
  by different browsers. Example:

    <video controls>
      <source src=\"foo.webm\" type=\"video/webm\">
      <source src=\"foo.ogg\" type=\"video/ogg\">
      <source src=\"foo.mov\" type=\"video/quicktime\">
      I'm sorry; your browser doesn't support HTML5 video.
    </video>")

(defelem span
  "The HTML <span> element is a generic inline container for phrasing content,
  which does not inherently represent anything. It can be used to group
  elements for styling purposes (using the class or id attributes), or because
  they share attribute values, such as lang. It should be used only when no
  other semantic element is appropriate. <span> is very much like a <div>
  element, but <div> is a block-level element whereas a <span> is an inline
  element.")

(defelem strong
  "The HTML Strong Element (<strong>) gives text strong importance, and is
  typically displayed in bold.

  BOLD vs. STRONG
  It is often confusing to new developers why there are so many ways to express
  the same thing on a rendered website. Bold and Strong are perhaps one of the
  most common. Why use <strong></strong> vs <b></b>? You have to type a whole
  lot more with strong and it produces the exact same result, right?

  Perhaps not; strong is a logical state, and bold is a physical state. Logical
  states separate presentation from the content, and by doing so allow for it
  to be expressed in many different ways. Perhaps instead of rendering some
  text as bold you want to render it red, or a different size, or underlined,
  or whatever. It makes more sense to change the presentational properties of
  strong than it does bold. This is because bold is a physical state; there is
  no separation of presentation and content, and making bold do anything other
  than bold text would be confusing and illogical.

  It is important to note that <b></b> does have other uses, when one wants to
  draw attention without increasing importance.

  EMPHASIS vs. STRONG
  While in HTML4, Strong simply indicated a stronger emphasis, in HTML5, the
  element is described as representing \"strong importance for its contents.\"
  This is an important distinction to make. While Emphasis is used to change
  the meaning of a sentence (\"I /love/ carrots\" vs. \"I love /carrots/\"),
  Strong is used to give portions of a sentence added importance (e.g.,
  \"*Warning!*  This is *very dangerous*.\") Both Strong and Emphasis can be
  nested to increase the relative degree of importance or stress emphasis,
  respectively.")

(defelem style
  "The HTML <style> element contains style information for a document, or part
  of a document. By default, the style instructions written inside that
  element are expected to be CSS.")

(defelem sub
  "The HTML Subscript Element (<sub>) defines a span of text that should be
  displayed, for typographic reasons, lower, and often smaller, than the main
  span of text.

    * This element should be used for typographical reasons only, i.e.
      changing the position of the text changing its meaning like in
      mathematical (like t2, though the use of a MathML formula should
      be considered) or chemical formulas (like H2O).

    * This element must not be used for styling purpose like the styling
      of the product name Latex. In that case CSS style should be used:
      the vertical-align property with the sub value will achieve the same
      effect.")

(defelem summary
  "The HTML summary element (<summary>) is used as a summary, caption, or
  legend for the content of a <details> element. Note: (1) If the <summary>
  element is omitted, the heading \"details\" will be used. (2) The default
  style for <summary> is display:list-item per HTML standard. If the style is
  being changed to display:block, the disclosure triangle will be dismissed,
  which is expected.")

(defelem sup
  "The HTML Superscript Element (<sup>) defines a span of text that should be
  displayed, for typographic reasons, higher, and often smaller, than the main
  span of text.

    * This element should be used for typographical reasons only, i.e.
      changing the position of the text changing its meaning like in
      mathematical (like f4, though the use of a MathML formula should be
      considered) or in French abbreviations (like Mlle, Mme or Cie).

    * This element must not be used for styling purpose like the styling of
      the product name Latex. In that case CSS style should be used: the
      vertical-align property with the super value will achieve the same
      effect.")

(defelem table
  "The HTML Table Element (<table>) represents tabular data - i.e., information
  expressed via a two dimensional data table. Note: Prior to the creation of
  CSS, HTML <table> elements were often used as a method for page layout. This
  usage has been discouraged since HTML 4. However, HTML emails are an
  exception where tables are still commonly used for layout purposes. The
  reason for this is poor CSS support in popular email clients.")

(defelem tbody
  "The HTML Table Body Element (<tbody>) defines one or more <tr> element
  data-rows to be the body of its parent <table> element (as long as no <tr>
  elements are immediate children of that table element.) In conjunction with
  a preceding <thead> and/or <tfoot> element, <tbody> provides additional
  semantic information for devices such as printers and displays. Of the
  parent table's child elements, <tbody> represents the content which, when
  longer than a page, will most likely differ for each page printed; while the
  content of <thead> and <tfoot> will be the same or similar for each page
  printed. For displays, <tbody> will enable separate scrolling of the
  <thead>, <tfoot>, and <caption> elements of the same parent <table> element.
  Note that unlike the <thead>, <tfoot>, and <caption> elements however,
  multiple <tbody> elements are permitted (if consecutive), allowing the
  data-rows in long tables to be divided into different sections, each
  separately formatted as needed.")

(defelem td
  "The Table cell HTML element (<td>) defines a cell of a table that contains
  data. It participates in the table model.")

(defelem template
  "The HTML template element <template> is a mechanism for holding client-side
  content that is not to be rendered when a page is loaded but may
  subsequently be instantiated during runtime using JavaScript. Think of a
  template as a content fragment that is being stored for subsequent use in
  the document. While the parser does process the contents of the <template>
  element while loading the page, it does so only to ensure that those
  contents are valid; the element's contents are not rendered, however.")

(defelem textarea
  "The HTML <textarea> element represents a multi-line plain-text editing
  control. A textarea has intrinsic dimensions, like a raster image. Example:

    <textarea name=\"textarea\" rows=\"10\" cols=\"50\">
      Write something here
   </textarea>")

(defelem tfoot
  "The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the
  columns of the table.")

(defelem th
  "The HTML element table header cell <th> defines a cell as header of a group
  of table cells. The exact nature of this group is defined by the scope and
  headers attributes.")

(defelem thead
  "The HTML Table Head Element (<thead>) defines a set of rows defining the
  head of the columns of the table.")

(defelem time
  "The HTML <time> element represents either a time on a 24-hour clock or a
  precise date in the Gregorian calendar (with optional time and timezone
  information). This element is intended to be used presenting dates and times
  in a machine readable format. This can be helpful for user agents to offer
  any event scheduling for user's calendar. Note: This element is not
  appropriate for instances where a specific date cannot be calculated, nor
  should it be used for dates prior to the introduction to the Gregorian
  calendar (due to complications with calculating those dates). Example:

    <p>
      The concert took place on
      <time datetime=\"2001-05-15T19:00\">May 15</time>.
    </p>")

(defelem ^:non-void title
  "The HTML <title> element defines the title of the document, shown in a
  browser's title bar or on the page's tab. It can only contain text, and any
  contained tags are ignored.")

(defelem tr
  "The HTML element table row <tr> defines a row of cells in a table. Those can
  be a mix of <td> and <th> elements.")

(defelem track
  "The HTML <track> element is used as a child of the media elements—<audio>
  and <video>. It lets you specify timed text tracks (or time-based data), for
  example to automatically handle subtitles. The tracks are formatted in
  WebVTT format (.vtt files) — Web Video Text Tracks. The type of data that
  track adds to the media is set in the kind attribute, which can take values
  of subtitles, captions, descriptions, chapters or metadata. The element
  points to a source file containing timed text that the browser exposes when
  the user requests additional data. A media element cannot have more than one
  track with the same kind, srclang, and label.")

(defelem u
  "The HTML Underline Element (<u>) renders text with an underline, a line
  under the baseline of its content. In HTML5, this element represents a span
  of text with an unarticulated, though explicitly rendered, non-textual
  annotation, such as labeling the text as being a proper name in Chinese text
  (a Chinese proper name mark), or labeling the text as being misspelled.
  Note: As with all purely styling elements, <u> has been deprecated in HTML 4
  and XHTML 1, but it has been re-introduced in HTML5 with other semantics. If
  you want to underline text in a non-semantic manner, you should use a <span>
  element, or another semantically appropriate element, and style it with the
  CSS text-decoration property, with the underline value.")

(defelem ul
  "The HTML <ul> element (or HTML Unordered List Element) represents an
  unordered list of items, namely a collection of items that do not have a
  numerical ordering, and their order in the list is meaningless. Typically,
  unordered-list items are displayed with a bullet, which can be of several
  forms, like a dot, a circle or a squared. The bullet style is not defined in
  the HTML description of the page, but in its associated CSS, using the
  list-style-type property.

  There is no limitation to the depth and imbrication of lists defined with the
  <ol> and <ul> elements.

  Note: The <ol> and <ul> elements both represent a list of items. They differ
  in that, with the <ol> element, the order is meaningful. As a rule of thumb
  to determine which one to use, try changing the order of the list items; if
  the meaning is changed, the <ol> element should be used, otherwise you can
  use <ul>.")

(defelem var
  "The HTML Variable Element (<var>) represents a variable in a mathematical
  expression or a programming context.")

(defelem video
  "Use the  HTML <video> element to embed video content in a document. The
  video element contains one or more video sources. To specify a video source,
  use either the src attribute or the <source> element; the browser will
  choose the most suitable one.")
