# XML Namespaces

Namespaces (both in element and attributes) are supported:

```clojure
(defelem ^:empty-tag foo:bar)

(foo:bar :xmlns:foo "http://example.org/rosé")
;=> <foo:bar xmlns:foo="http://example.org/rosé">
```

