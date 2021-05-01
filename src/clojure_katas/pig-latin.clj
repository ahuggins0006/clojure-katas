(ns clojure-katas.pig-latin
  (:require [clojure.string :as str]))

;; Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.

;; Examples
;; (piglatin/pig-it "Pig latin is cool") ; "igPay atinlay siay oolcay"
;; (piglatin/pig-it "Hello world !")     ; "elloHay orldway !"




(defn pig-it-one [word]
  (if (re-matches #"[.!?\\-]" word)
    word
    (apply str (concat (rest word) (cons (first word) "ay")))))

(defn pig-it [s] 
  (str/join " "(map pig-it-one (str/split s #" "))))

(pig-it "Pig latin is cool")
