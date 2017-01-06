# HelpMate
[![Build Status](https://travis-ci.org/rm-hull/helpmate.svg?branch=master)](http://travis-ci.org/rm-hull/helpmate)
[![Coverage Status](https://coveralls.io/repos/rm-hull/helpmate/badge.svg?branch=master)](https://coveralls.io/r/rm-hull/helpmate?branch=master)
[![Dependencies Status](https://jarkeeper.com/rm-hull/helpmate/status.svg)](https://jarkeeper.com/rm-hull/helpmate)
[![Downloads](https://jarkeeper.com/rm-hull/helpmate/downloads.svg)](https://jarkeeper.com/rm-hull/helpmate)
[![Clojars Project](https://img.shields.io/clojars/v/rm-hull/helpmate.svg)](https://clojars.org/rm-hull/helpmate)
[![Maintenance](https://img.shields.io/maintenance/yes/2017.svg?maxAge=2592000)]()

HelpMate is a Clojure/ClojureScript library for templating/emitting SGML-like
content. It uses S-Expressions to represent elements, and maps to represent an
element's attributes. HelpMate is a strained portmanteau of _Helpful HTML
template_.

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

## Install

There is a version hosted at [Clojars](https://clojars.org/rm-hull/helpmate).
For leiningen include a dependency in your `project.clj` file:

```clojure
[rm-hull/helpmate "0.1.3"]
```

## API Documentation

See [www.destructuring-bind.org/helpmate](http://www.destructuring-bind.org/helpmate/) for API details.

## Basic Usage

There is a predefined library of all (current) HTML elements complete with
doc-strings:

```clojure
(use 'helpmate.html)

(div
  (p "Hello"
     (strong "world")))
;=> <div><p>Hello <strong>world</strong></p></div>
```
Convention dictates that attributes are specified first, then children. Child elements
may be given in SEQable collection, or as varargs, and can be arbitrarily nested; thus,
they can be combined into normal Clojure code, as per the opening example.

Some elements have certain behaviour, for example `(div)` expands into `<div></div>`,
whereas `(br)` expands into `<br>`. Most other empty tags will self-close, eg. `(p)`
expands into `<p/>` - these are specified with meta-data when the element was defined.

### Specifying attributes

Attributes can be supplied as a map of key/value pairs:

```clojure
(a {:id "puppies" :class "flush--right" :target "_blank" :href "/puppies.html"}
  (img {:src "/img/puppies.png"}))
;=> <a id="puppies" class="flush--right" target="_blank" href="/puppies.html"><img src="/img/puppies.png"></a>
```

Alternatively, the braces can be omitted, as long as there are pairs of keys
and values (and in which case, the keys _must_ be Clojure keywords and the
valeus _must_ be string, number or nil):

```clojure
(div :id "main" :data-target "#nav"
  (h2 :class "large editable-field inactive" "Dashboard"))
;=> <div id="main" data-target="#nav"><h2 class="large editable-field inactive">Dashboard</h2></div>
```

`:id` and `:class` values can be shortened even further, as below, where a
Clojure keyword starting with an octothorpe (`#`) is treated as an id, whereas a
keyword starting with dot (`.`) is treated as a class. Keywords with embedded dots
are treated as multiple classes.

```clojure
(div :#main :data-target "#nav"
  (h2 :.large.editable-field.inactive "Dashboard"))
;=> <div id="main" data-target="#nav"><h2 class="large editable-field inactive">Dashboard</h2></div>
```

### Creating custom elements

The `defelem` macro can be used to create element definitions. The simplest
form is:

```clojure
(defelem book)
(defelem author)

(author :first-name "Barry" :surname "Fungus"
  (book :year 1999 "One hundred ways to kill mice")
  (book :year 2012 "The Dummys guide to Sensible Eating Habits"))
```

after formatting, gives:

```xml
<author first-name="Barry" surname="Fungus">
  <book year="1999">One hundred ways to kill mice</book>
  <book year="2012">The Dummys guide to Sensible Eating Habits</book>
</author>
```

Of course, modelling the data structure with elements or attributes is a matter
of taste; but with HelpMate, you can arbitrarity make that decision.

`defelem` can also take an optional doc-string:

```clojure
(defelem publisher
  "A company or person that prepares and issues books, journals, or music for
  sale. Valid attributes: name, publisher-code, Valid child elements: author.")

(clojure.repl/doc publisher)
;=> -------------------------
;=> helpmate.html-test/publisher
;=>  A company or person that prepares and issues books, journals, or music for
;=>  sale. Valid attributes: name, publisher-code, Valid child elements: author.
```

Meta-data is also respected, and use of `^:deprecated` is encouraged where
appropriate (and actively used within the `helpmate.html` namespace). Other
valid meta-data flags are:

 * `^:non-void` - denotes that the element _must_ have an end-tag, such as
   `<div>` or `<script>` for example. Non-void tags will never self-close.
 * `^:empty-tag` - signals that the element is expected to have no child
   elements (and will throw an exception if evaluated with children), such
   as `<img>` or `<br>` elements. An empty tag implies that an element is
   also void.

### XML Namespaces

Namespaces (both in element and attributes) are supported:

```clojure
(defelem ^:empty-tag foo:bar)

(foo:bar :xmlns:foo "http://example.org/rosé")
;=> <foo:bar xmlns:foo="http://example.org/rosé">
```

### Examples

Using the SVG tags from the `helpmate.svg` namespace:

```clojure
(svg {:viewBox "0 0 95 50" :xmlns "http://www.w3.org/2000/svg"}
     (g {:stroke "green" :fill "white" :stroke-width 5}
        (circle {:cx 25 :cy 25 :r 15})
        (circle {:cx 40 :cy 25 :r 15})
        (circle {:cx 55 :cy 25 :r 15})
        (circle {:cx 70 :cy 25 :r 15}))))
```

produces:

![example-SVG](https://rawgithub.com/rm-hull/helpmate/master/doc/example.svg)

And another more substantial example:

```clojure
(defelem animateMotion)
(defelem mpath)

(svg :width 120 :height 120 :viewBox "0 0 120 120"
     :xmlns "http://www.w3.org/2000/svg" :version "1.1"
     :xmlns:xlink "http://www.w3.org/1999/xlink"

     (comment "Draw the outline of the motion path in grey, along
              with 2 small circles at key points")

     (path :d "M10,110 A120,120 -45 0,1 110 10 A120,120 -45 0,1 10,110"
           :stroke "lightgrey" :stroke-width "2"
           :fill "none" :id "theMotionPath")
     (circle :cx 10 :cy 110 :r 3 :fill "lightgrey")
     (circle :cx 110 :cy 10 :r 3 :fill "lightgrey")

     (comment "Red circle which will be moved along the motion path.")
     (circle :cx "" :cy "" :r 5 :fill "red"

             (comment "Define the motion path animation")
             (animateMotion :dur "6s" :repeatCount "indefinite"
                            (mpath :xlink:href "#theMotionPath")))))
```

![animate-SVG](https://rawgithub.com/rm-hull/helpmate/master/doc/animate.svg)

## References

* https://developer.mozilla.org/en/docs/Web/HTML/Element
* https://developer.mozilla.org/en-US/docs/Web/SVG/Element

## Attribution

  * Docstring content scraped from Mozilla Developer Network, the
    content of which is available under the terms of the [Creative Commons
    Attribution-ShareAlike license](http://creativecommons.org/licenses/by-sa/2.5/) (CC-BY-SA), v2.5.
  * Code examples / inspiration from https://github.com/weavejester/hiccup.
  * SVG examples transcribed from Mozilla Developer Network

## License

### MIT License

Copyright (c) 2016 Richard Hull

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
