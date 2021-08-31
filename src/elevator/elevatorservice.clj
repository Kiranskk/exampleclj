(ns elevator.elevatorservice)

(def max-floors 10)
(def allowed-basement-floors -2)

(defn move-up [n]
  (if (>= n max-floors) n (inc n))
  )

(defn move-down [n]
  (if (<= n allowed-basement-floors) n (dec n))
  )

(defn check-floors [n]
  (cond
    (>= n max-floors) (throw (new Exception "not allowed than max floors"))
    (<= n allowed-basement-floors) (throw (new Exception "not allowed than 3 level basement"))
    )
  )

(defn take-to-floor [from to]
  (check-floors to)
  (let [cmds (if (> to from) (repeat (- to from) "up") (repeat (- from to) "down") )
        ]
    (conj (into [] cmds)  "open" "close")
    )
  )


