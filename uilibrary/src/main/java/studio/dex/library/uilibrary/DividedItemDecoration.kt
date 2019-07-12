package studio.dex.library.uilibrary

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class DividedGridItemDecoration(val spanCount:Int,val spacing:Int): RecyclerView.ItemDecoration(){
    private val halfSpacing = spacing/2

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val childPosition = parent.getChildLayoutPosition(view)
        when {
            childPosition%spanCount == 0 -> outRect.set(spacing,halfSpacing,halfSpacing,halfSpacing)
            childPosition%spanCount == (spanCount-1) -> //                    最右侧
                outRect.set(halfSpacing,halfSpacing,spacing,halfSpacing)
            else -> //                    中间
                outRect.set(halfSpacing,halfSpacing,halfSpacing,halfSpacing)
        }

    }

}