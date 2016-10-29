# Basic Usage

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
they can be combined into normal Clojure code, as per the example in the introduction.

Some elements have certain behaviour, for example `(div)` expands into `<div></div>`,
whereas `(br)` expands into `<br>`. Most other empty tags will self-close, eg. `(p)`
expands into `<p/>` - these are specified with meta-data when the element was defined.

