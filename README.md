# HelpMate
[![Build Status](https://travis-ci.org/rm-hull/helpmate.svg?branch=master)](http://travis-ci.org/rm-hull/helpmate)
[![Coverage Status](https://coveralls.io/repos/rm-hull/helpmate/badge.svg?branch=master)](https://coveralls.io/r/rm-hull/helpmate?branch=master)
[![Dependencies Status](https://jarkeeper.com/rm-hull/helpmate/status.svg)](https://jarkeeper.com/rm-hull/helpmate)
[![Downloads](https://jarkeeper.com/rm-hull/helpmate/downloads.svg)](https://jarkeeper.com/rm-hull/helpmate)
[![Clojars Project](https://img.shields.io/clojars/v/rm-hull/helpmate.svg)](https://clojars.org/rm-hull/helpmate)
[![Maintenance](https://img.shields.io/maintenance/yes/2016.svg?maxAge=2592000)]()

HelpMate is a Clojure library for templating/emitting XML-like content. It uses
S-Expressions to represent elements, and maps to represent an element's
attributes. HelpMate is a strained portmanteau of _Helpful HTML template_.

All the current [HTML](https://developer.mozilla.org/en/docs/Web/HTML/Element)
and [SVG](https://developer.mozilla.org/en-US/docs/Web/SVG/Element) elements
are represented with doc-strings scraped from Mozilla Developer Network, the
content of which is available under the terms of the [Creative Commons
Attribution-ShareAlike license](http://creativecommons.org/licenses/by-sa/2.5/) (CC-BY-SA), v2.5.

Custom elements can be created by way of the `defelem` macro: this allows
arbitrary XML tags to be represented in regular Clojure code, intersperced
with forms like `map` and `for`, making templating more convenient:

```clojure
(ul
  (for [x (range 1 4)]
    (li x)))
; => "<ul><li>1</li><li>2</li><li>3</li></ul>"
```

## Install

There is a version hosted at [Clojars](https://clojars.org/rm-hull/infix).
For leiningen include a dependency in your `project.clj` file:

```clojure
[rm-hull/helpmate "0.1.0"]
```

## API Documentation

See [www.destructuring-bind.org/helpmate](http://www.destructuring-bind.org/helpmate/) for API details.

## Basic Usage

> TODO

## References

* https://developer.mozilla.org/en/docs/Web/HTML/Element
* https://developer.mozilla.org/en-US/docs/Web/SVG/Element

## Attribution

* Docstring content scraped from Mozilla Developer Network, the
  content of which is available under the terms of the [Creative Commons
  Attribution-ShareAlike license](http://creativecommons.org/licenses/by-sa/2.5/) (CC-BY-SA), v2.5.

* Examples / inspiration from https://github.com/weavejester/hiccup.

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
