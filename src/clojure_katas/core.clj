(ns clojure-katas.core)


;; Kata Description
;; The goal of this exercise is to convert a string to a new string where each
;; character in the new string is "(" if that character appears only once in the
;; original string, or ")" if that character appears more than once in the
;; original string. Ignore capitalization when determining if a character is a duplicate.
;;
;; Examples
;; "din"      =>  "((("
;; "recede"   =>  "()()()"
;; "Success"  =>  ")())())"
;; "(( @"     =>  "))(("
;;
;; Completed on 29 APR 2021


(def sample1 "din")
(def sample2 "recede")

(frequencies "range")
;; => {\d 1, \i 1, \n 1}

(apply str (map (fn [[_ n]] (if (= 1 n) "(" ")")) (frequencies sample2)))
;; => "((("

(def freq-2 (frequencies sample2));; => {\r 1, \e 3, \c 1, \d 1}

(let [freq (frequencies sample2)]
  (apply str(map (fn [c] (if (= 1 (freq c)) "(" ")")) sample2) ))


(defn convert-string [sample]
  (let [low-sample (clojure.string/lower-case sample)
        freq (frequencies low-sample)]
  (apply str (map (fn [c] (if (= 1 (freq c)) "(" ")")) low-sample))))

(convert-string "range")


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
  (-> (for [xs (->> input (partition-by identity))] (first xs)) vec)
)

(unique-in-order "AAAABBBCCDAABBB")
