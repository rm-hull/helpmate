(ns helpmate.core
  (:refer-clojure :exclude [comment])
  (:require
   [clojure.string :as str]
   [helpmate.attributes :as attrs]))

(def ^:private doctype-declarations
  {:html5 "html"
   :html-4.01-strict "HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\""
   :html-4.01-transitional "HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\""
   :html-4.01-frameset "HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\""
   :xhtml-1.0-strict "html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\""
   :xhtml-1.0-transitional "html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\""
   :xhtml-1.0-frameset "html PUBLIC \"-//W3C//DTD XHTML 1.0 Frameset//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd\""
   :xhtml-1.1 "html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\""})

(defn doctype
  "The <!DOCTYPE> declaration must be the very first thing in your HTML
  document, before the <html> tag. The <!DOCTYPE> declaration is not an HTML
  tag; it is an instruction to the web browser about what version of HTML the
  page is written in. In HTML 4.01, the <!DOCTYPE> declaration refers to a
  DTD, because HTML 4.01 was based on SGML. The DTD specifies the rules for
  the markup language, so that the browsers render the content correctly.
  HTML5 is not based on SGML, and therefore does not require a reference to a
  DTD. Tip: Always add the <!DOCTYPE> declaration to your HTML documents, so
  that the browser knows what type of document to expect.

  Valid keyword shortcut values are shown below. If the value is a string
  then that will be used instead.

    :html5
    :html-4.01-strict
    :html-4.01-transitional
    :html-4.01-frameset
    :xhtml-1.0-strict
    :xhtml-1.0-transitional
    :xhtml-1.0-frameset
    :xhtml-1.1"
  [value]
  (str "<!DOCTYPE" (get doctype-declarations value value) ">"))

(defn cdata
  "The CDATASection interface represents a CDATA section that can be used
  within XML to include extended portions of unescaped text, such that the
  symbols < and & do not need escaping as they normally do within XML when
  used as text."
  [value]
  (str "<![CDATA[" value "]]>"))

(defn comment
  "The Comment interface represents textual notations within markup; although
  it is generally not visually shown, such comments are available to be read
  in the source view. Comments are represented in HTML and XML as content
  between '<!--' and '-->'. In XML, the character sequence '--' cannot be used
  within a comment."
  [value]
  (str "<!--" value "-->"))

(defn empty-elem [tag]
  (if (keyword? tag)
    (empty-elem (name tag))
    (fn
      ([] (str "<" tag ">"))
      ([attrs] (str "<" tag (attrs/expand attrs) ">")))))

(defn elem
  ([tag]
   (elem tag true false))

  ([tag self-closing?]
   (if (keyword? tag)
     (elem (name tag) self-closing?)
     (fn [& more]
       (let [[attrs & children] (if (map? (first more)) more (cons nil more))]
         (if (and self-closing? (empty? children))
           (str "<" tag (expand-attrs attrs) "/>")
           (str "<" tag (expand-attrs attrs) ">"
                (str/join (flatten children))
                "</" tag ">")))))))

(defmacro defelem [tag & [doc-string]]
  (let [opts (meta tag)
        doc-string (or doc-string "")]
    (if (:empty-tag opts)
      `(def ~tag ~doc-string (empty-elem ~(name tag)))
      `(def ~tag ~doc-string (elem ~(name tag) ~(not (:non-void opts)))))))
