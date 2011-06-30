(ns euler.core)

(defn divides? [d n] (zero? (mod n d)))

(def fibs
     (lazy-cat [0 1] (map + (rest fibs) fibs)))
