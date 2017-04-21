;; Filename: parse.clj
;; Copyright (c) 2008-2017 Clement Trösa <iomonad@riseup.net>
;; 
;; Last-Updated: 04/21/2017 Friday 23:27:04
;; Description: Parsing utils

(ns gcwl.parse)

(def admin (atom [])) ;; Registred users

(defn admin? [nick]
  "Predicate to check if user is administrator"
  (if (.contains @admin)
    (true)
    (false)))

(defn handleerr [error]
  "Just avoiding formating usage"
  (str (format "Error: %s" error)))

(defn extract-command [message]
  "Extract command from raw message"
  (if-let [[_ cmd rest-of-text]
           (re-find #"^[.](\S+)\s*(.*)$" (:text message))]
    [cmd (assoc message :text rest-of-text
                :command cmd)]))

(defn extract-word [message]
  "Extract arguments from raw message"
  (if-let [[_ word rest-of-text]
           (re-find #"^(\S+)\s*(.*)$" (:text message))]
    [word (assoc message :text rest-of-text)]))
