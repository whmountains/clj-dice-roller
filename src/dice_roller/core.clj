(ns dice-roller.core
  (:require [clojure.spec.alpha :as s]))

(defn roll
  "Rolls some dice, like (roll 3 6) would be three d6."
  [amount die]
  (vec (map #(inc (rand-int %))
            (filter pos? (repeat amount die)))))

;; Normal case
(roll 3 6)
;; => [1 1 6]

;; What about a very large die?
(roll 3 100)

;; What about a one-sided die?
(roll 3 1)
;; => [1 1 1]

;; Or zero sided?
;; Interesting, it produces an empty array
(roll 5 0)
;; => []

;; What if we ask for zero rolls?
(roll 0 6)
;; => []
