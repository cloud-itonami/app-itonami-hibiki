(ns itonami.app.entry
  "Hibiki on the device (AWAI-3502). Calls hibiki.methods.present-plan/build-plan
  unchanged. `render` is R0-gated in the repo and is not offered. A charter
  violation in the input is refused with the repo's own message."
  (:require [hibiki.methods.present-plan :as plan]
            [itonami.app.run :as run]))

(run/register!
 {:name "build-plan" :label "計画を作る"
  :help "提案（proposalId / finding / why / action / severity）から、ナレーション・場面・効果音の計画を作ります。\"fakeUrgency\" や \"engagementOptimized\" などを true にすると、憲章のゲートで退けます。"
  :example "{\"proposalId\" \"ossekai-R14-2606\"
 \"finding\" \"aggregate-share 41% < 50% floor\"
 \"why\" \"targeted dispatch is drifting above the aggregate-first floor\"
 \"action\" \"cap mention_dispatcher x 0.5 next quarter until recovery\"
 \"severity\" \"structural\"
 \"linkUrl\" \"at://did:web:ossekai.itonami.cloud/app.bsky.feed.post/abc\"}"
  :run (fn [proposal] (plan/build-plan proposal))})
