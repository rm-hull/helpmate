;; The MIT License (MIT)
;;
;; Copyright (c) 2016 Richard Hull
;;
;; Permission is hereby granted, free of charge, to any person obtaining a copy
;; of this software and associated documentation files (the "Software"), to deal
;; in the Software without restriction, including without limitation the rights
;; to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;; copies of the Software, and to permit persons to whom the Software is
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

(ns helpmate.svg-test
  (:refer-clojure :exclude [comment])
  (:require
   [helpmate.core :refer [defelem]]
   [helpmate.sgml :refer [comment]]))

(defelem svg)
(defelem path)
(defelem g)
(defelem circle)
(defelem animateMotion)
(defelem mpath)

(spit
 "doc/example.svg"
 (svg {:viewBox "0 0 95 50" :xmlns "http://www.w3.org/2000/svg"}
      (g {:stroke "green" :fill "white" :stroke-width 5}
         (circle {:cx 25 :cy 25 :r 15})
         (circle {:cx 40 :cy 25 :r 15})
         (circle {:cx 55 :cy 25 :r 15})
         (circle {:cx 70 :cy 25 :r 15}))))

(spit
 "doc/animate.svg"
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