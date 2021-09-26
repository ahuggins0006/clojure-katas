(ns clojure-katas.unique-in-order
    (:require [clojure.test :as test]))
;; Unique in Order
;; Kata Description
;; Implement the function unique_in_order which takes as argument a sequence and returns a list of items without any elements with the same value next to each other and preserving the original order of elements.

;; For example:
;;
;; uniqueInOrder("AAAABBBCCDAABBB") == {'A', 'B', 'C', 'D', 'A', 'B'}
;; uniqueInOrder("ABBCcAD")         == {'A', 'B', 'C', 'c', 'A', 'D'}
;; uniqueInOrder([1,2,2,3,3])       == {1,2,3}
;;


(defn unique-in-order [input]
  (-> (for [xs (->> input (partition-by identity))] (first xs)) vec))

(unique-in-order "AAAABBBCCDAABBB")
;; => [\A \B \C \D \A \B]


(test/deftest unique-in-order-test

  (test/is (= (unique-in-order "AAAABBBCCDAABBB") [\A \B \C \D \A \B]))

  (test/is (= (unique-in-order "ABBCcAD") [\A \B \C \c \A \D]))

  (test/is (= (unique-in-order [1,2,2,3,3]) [1 2 3])))

(test/run-all-tests)
