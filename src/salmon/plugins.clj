;; Filename: plugins.clj
;; Copyright (c) 2008-2017 Clement Trösa <iomonad@riseup.net>
;; 
;; Last-Updated: 05/10/2017 Wednesday 22:12:57
;; Description: Plugins dsl to build commands

(ns salmon.plugins
  (:require [salmon.plugins.ping :as ping]
            [salmon.plugins.date :as date]
            [salmon.plugins.auth :as auth]
            [salmon.plugins.man :as man]
            [salmon.plugins.help :as help])
  (:gen-class))

;; Atom that contains enables plugins
(def plugins-enabled (atom [ping/plugin
                            date/plugin
                            man/plugin
                            help/plugin]))

(defn list-plugins []
  "List enabled plugins to *out*"
  (doseq [p @plugins-enabled]
    (println (format "[*] Enabled plugin: %s" p))))
