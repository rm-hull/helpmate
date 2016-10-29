# Examples

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

