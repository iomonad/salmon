(ns salmon.core-test
  (:require [clojure.test :refer :all]
            [salmon.parse :as parse]))

(deftest some-foo-test
  (testing "Make sure test suite works"
    (is (= 1 1))))

(deftest nick-parsing-test
  (testing "Make sure nick extraction is done"
    (is (= "iomonadk"
           (parse/extract-nick-from-raw ":iomonad!~iomonad@wow.such.vhost PRIVMSG #bottest :.ping")))))
