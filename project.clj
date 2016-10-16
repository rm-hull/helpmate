(defproject rm-hull/helpmate "0.1.2-SNAPSHOT"
  :description "A Clojure library for emitting SGML (HTML,SVG,XML) fragments"
  :url "https://github.com/rm-hull/helpmate"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.flatland/useful "0.11.5"]]
  :scm {:url "git@github.com:rm-hull/helpmate.git"}
  :vcs :git
  :source-paths ["src"]
  :jar-exclusions [#"(?:^|/).git"]
  :codox {
    :source-paths ["src"]
    :output-path "doc/api"
    :source-uri "http://github.com/rm-hull/helpmate/blob/master/{filepath}#L{line}"  }
  :min-lein-version "2.7.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
      :plugins [
        [lein-codox "0.10.1"]
        [lein-cljfmt "0.5.6"]
        [lein-cloverage "1.0.7"]]
      :dependencies [
        [org.clojure/clojure "1.8.0"]]}})

