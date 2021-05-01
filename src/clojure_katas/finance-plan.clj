(ns clojure-katas.finance-plan)


;; Kata Description
;; Please see https://www.codewars.com/kata/559ce00b70041bc7b600013d

(defn calc_summation [n]
  (/ (* (+ n (* 2 n)) (+ n 1)) 2))

(defn finance [n]
  (loop [cnt n
         acc 0]
       (if (zero? cnt)
           acc
          (recur (dec cnt) (+ acc (calc_summation cnt))))))

(finance 5000);; => 62537505000
