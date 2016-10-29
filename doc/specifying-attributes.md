# Specifying attributes

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

