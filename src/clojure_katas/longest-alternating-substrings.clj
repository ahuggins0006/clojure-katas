(ns clojure-katas.longest-alternating-substrings
  (:require [clojure.string :as str]))
;;Write a function that takes a string of digits and returns the longest substring that contains only alternating odd/even digits.
;;If two substrings have the same length, return the one that appears first.
;;
;;Examples
;;
;;(longest-alt-subs "") ;=> ""
;;(longest-alt-subs "1") ;=> "1"
;;(longest-alt-subs "123") ;=> "123"
;;(longest-alt-subs "13") ;=> "1"
;;(longest-alt-subs "122381") ;=> "2381"


(defn digits->vec [digits] (if-not (empty? digits)
                             (into [](map #(Integer/parseInt %) (str/split digits #"")))
                             digits
                             ))

(digits->vec "123")
(digits->vec "")

(defn check-alternating [v1 v2]
  (or
     (and (odd? (first v1)) (even? (last v2)))
     (and (even? (first v1)) (odd? (last v2)))))

(defn step-through [digits acc seq-store]
  (if (empty? digits)
    (conj seq-store acc)
    (if (empty? acc)
      (recur (rest digits) (conj acc (first digits)) seq-store)
      (recur
       (rest digits)
       (if (check-alternating digits acc)
               (conj acc (first digits)) [(first digits)])
        (if (check-alternating digits acc)
                seq-store (conj seq-store acc))))))



(step-through (digits->vec "12344") [] [])
(step-through (digits->vec "13") [] [])
(first (sort-by count > (step-through (digits->vec "122381") [] [])))



(defn alter-subs [s]

   (apply str (first (sort-by count > (step-through (digits->vec s) [] [])))))



;;test cases
(alter-subs "1234")
(alter-subs "122381")
(alter-subs "594127169973391692147228678476")
(alter-subs "721449827599186159274227324466")
