# Creating custom elements

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
