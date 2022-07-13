package io.kexec.heimdall.tool.state

interface BlockMapRenderPoolDelegate<T> {
  fun onSinglePlaybackComplete(pool: BlockMapRenderPool<T>, slice: ChangelogSlice, tracker: BlockLogTracker)
  fun onAllPlaybackComplete(pool: BlockMapRenderPool<T>, trackers: Map<ChangelogSlice, BlockLogTracker>)
}
