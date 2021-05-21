(ns othe.core ;; 名前空間を定義
  (:use
   othe.view
   othe.model))

(defn on-command ;; 関数を定義
  "Viewからのコマンド通知を処理するハンドラ"
  [cmdline]
  (let [cmd (first cmdline)
        pos (second cmdline)]
    (cond
      (= cmd :move) (play-move pos)
      (= cmd :exit) (System/exit 0)
      :else nil)))

(defn -main ;; 関数定義
  "エントリポイント"
  [& args]
  (init-view on-command)
  (init-game on-state-changed)
  (start-ui))

