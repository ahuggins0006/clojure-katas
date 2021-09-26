(ns clojure-katas.duplicate-encoder
  (:require [clojure.test :as test]))

(comment

  The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate. )


(comment

  Examples
  "din"      =>  "((("
  "recede"   =>  "()()()"
  "Success"  =>  ")())())"
  "(( @"     =>  "))(("

)


(defn encode-dups [text]
  (let [low-text (clojure.string/lower-case text)
        freq (frequencies low-text)]
    (apply str (map (fn [c] (if (= 1 (freq c)) "(" ")")) low-text))))


(encode-dups "din");; => "((("

(test/deftest encode-dups-test
  (test/is (= (encode-dups "din") "((("))
  (test/is (= (encode-dups "recede") "()()()"))
  (test/is (= (encode-dups "Success") ")())())"))
  (test/is (= (encode-dups "(( @") "))(("))


  )

(test/run-tests)
;; => {:test 1, :pass 4, :fail 0, :error 0, :type :summary}
