(ns clojure-katas.largest-diff-increasing-idxs
    (:require [clojure.test :as test]))

;; Write a function which takes an array data of numbers and returns the largest difference in indexes j - i such that data[i] <= data[j]

;; showing the steps that lead up to final form
;;
(def sample [9 4 1 10 3 4 0 -1 -2])
;; values and their positions
(def indexed-sample (map-indexed vector sample))
;; => ([0 9] [1 4] [2 1] [3 10] [4 3] [5 4] [6 0] [7 -1] [8 -2])
;; generate all parirs
(def all-pairs (for [a indexed-sample
                     b (next indexed-sample)] [a b]))

(take 2 all-pairs)
;; => ([[0 9] [1 4]] [[0 9] [2 1]])

;; all pairs where the first one is less than or equal to the second one
(def start-end-indecies (remove nil? (map (fn [ [[a b] [c d]] ] (if (<= b d) [[a c]] nil))  all-pairs)))

(take 2 start-end-indecies)

(reduce max (map (fn [[[a b]]] (- b a)) start-end-indecies))

;; compose elements into one function
(defn largestDifference [data]
 (let [ indexed-data (map-indexed vector data)
        all-pairs    (for [a indexed-data b (next indexed-data)] [a b])
        start-ends   (remove nil? (map (fn [ [[a b] [c d]] ] (if (<= b d) [[a c]] nil))  all-pairs))
       ]
 (reduce max (map (fn [[[a b]]] (- b a)) start-ends ))))
