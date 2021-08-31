(ns elevatorservice-test
  (:require [elevator.elevatorservice :as src]
            [clojure.test :refer :all]
            )
  )

(deftest move-up-test
   (testing "testing move up fn"
      (is (= 2 (src/move-up 1)) "move up will inc floor")
      (is (= 10 (src/move-up 10)) "move up more than allowed floor should not inc")
      ))

(deftest move-down-test
  (testing "testing down fn"
    (is (= 0 (src/move-down 1)) "move down decrements" )
    (is (= -4 (src/move-down -4)) "move down should not allow to decrement more than 3 levels down")
    ))

(deftest take-to-floor-test
  (testing "testing take to a floor fn"
    (is (= ["up" "up" "up" "open" "close"] (src/take-to-floor 1 4)) "take to a floor commands moving up" )
    (is (= ["down" "down" "open" "close"] (src/take-to-floor 4 2)) "take to a floor commands moving down" )
    (is (= ["open" "close"] (src/take-to-floor 2 2)) "take to a floor commands same floor" )
    (is (thrown? Exception (src/take-to-floor 2 20) ) "give the message for taking to invalid floors" )
    ))

