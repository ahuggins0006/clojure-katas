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


