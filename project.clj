(defproject rm-hull/helpmate "0.1.3"
  :description "A Clojure/clojurescript library for templating/emitting SGML (HTML,SVG,XML) fragments."
  :url "https://github.com/rm-hull/helpmate"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.flatland/useful "0.11.5"]]
  :scm {:url "https://github.com/rm-hull/helpmate.git"}
  :vcs :git
  :source-paths ["src"]
  :jar-exclusions [#"(?:^|/).git"]
  :codox {
    :source-paths ["src"]
    :output-path "doc/api"
    :doc-files [
      "doc/introduction.md",
      "doc/basic-usage.md",
      "doc/specifying-attributes.md"
      "doc/creating-custom-elements.md"
      "doc/xml-namespaces.md"
      "doc/examples.md"
      "doc/references.md"
      "LICENSE.md"]
    :source-uri "http://github.com/rm-hull/helpmate/blob/master/{filepath}#L{line}"
    :themes [:default [:google-analytics {:tracking-code "UA-39680853-8" }]]}
  :min-lein-version "2.7.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
      :plugins [
        [lein-codox "0.10.3"]
        [lein-cljfmt "0.5.7"]
        [lein-cloverage "1.0.9"]]
      :dependencies [
        [org.clojure/clojure "1.8.0"]
        [google-analytics-codox-theme "0.1.0"]]}})

