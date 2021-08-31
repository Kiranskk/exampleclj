(ns example1-test
  (:require [clojure.test :refer :all]
            [example.example1 :refer :all])
  )

(deftest say-hello-test
   (testing "testing say-hello"
    (is (= "hello test" (say-hello "test")))
   ))
