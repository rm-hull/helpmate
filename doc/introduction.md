# Introduction

HelpMate is a Clojure library for templating/emitting SGML-like content. It
uses S-Expressions to represent elements, and maps to represent an element's
attributes. HelpMate is a strained portmanteau of _Helpful HTML template_.

All the current [HTML](https://developer.mozilla.org/en/docs/Web/HTML/Element)
and [SVG](https://developer.mozilla.org/en-US/docs/Web/SVG/Element) elements
are represented with doc-strings scraped from Mozilla Developer Network, the
content of which is available under the terms of the [Creative Commons
Attribution-ShareAlike license](http://creativecommons.org/licenses/by-sa/2.5/)
(CC-BY-SA), v2.5.

Planned additional definitions include

  * [RDF](https://www.w3.org/TR/rdf-syntax-grammar/)
  * [MathML](https://developer.mozilla.org/en-US/docs/Web/MathML/Element)

Custom elements can be created by way of the `defelem` macro: this allows
arbitrary SGML tags to be represented in regular Clojure code, intersperced
with forms like `map` and `for`, making templating much more convenient:

```clojure
(defelem ul)
(defelem li)

(ul
  (for [x (range 1 4)]
    (li x)))
; => "<ul><li>1</li><li>2</li><li>3</li></ul>"
```
