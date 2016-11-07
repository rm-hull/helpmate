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

(ns helpmate.sgml
  (:refer-clojure :exclude [comment]))

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
  (str "<!-- " value " -->"))
