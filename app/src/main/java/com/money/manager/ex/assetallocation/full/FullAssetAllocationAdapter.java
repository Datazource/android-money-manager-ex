/*
 * Copyright (C) 2012-2016 The Android Money Manager Ex Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.money.manager.ex.assetallocation.full;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.money.manager.ex.Constants;
import com.money.manager.ex.R;

import java.util.List;

/**
 * Adapter for the full Asset Allocation display.
 */
public class FullAssetAllocationAdapter
    extends RecyclerView.Adapter<FullAssetClassViewHolder> {

    public FullAssetAllocationAdapter(List<AssetClassViewModel> model) {
        this.model = model;
    }

    private List<AssetClassViewModel> model;
//    private int expandedPosition = Constants.NOT_SET;

    @Override
    public FullAssetClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_full_asset_class, parent, false);
        return new FullAssetClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FullAssetClassViewHolder holder, int position) {
        AssetClassViewModel item = this.model.get(position);

        // color the background, depending on the level. Support 5 levels?
        // todo: the last level should not be green?
        int colorDepth = 50 * item.level;
        holder.listItem.setBackgroundColor(Color.argb(225, 0, 100 + colorDepth, 0));

        holder.assetClassTextView.setText(item.assetClass.getName());
        holder.setAllocationTextView.setText(item.assetClass.getAllocation().toString());
        holder.currentAllocationTextView.setText(item.assetClass.getCurrentAllocation().toString());
        holder.allocationDiffTextView.setText(item.assetClass.getDiffAsPercentOfSet().toString());

        holder.setValueTextView.setText(item.assetClass.getValue().toString());
        holder.currentValueTextView.setText(item.assetClass.getCurrentValue().toString());
        holder.valueDiffTextView.setText(item.assetClass.getDifference().toString());

//        if (position == expandedPosition) {
//            holder.valuetPanel.setVisibility(View.VISIBLE);
//        } else {
//            holder.valuetPanel.setVisibility(View.GONE);
//        }
    }

    @Override
    public int getItemCount() {
        return this.model.size();
    }

//    public void onClick(View view) {
//        FullAssetClassViewHolder holder = (FullAssetClassViewHolder) view.getTag();
//
//        // Check for an expanded view, collapse if you find one
//        if (expandedPosition >= 0) {
//            int prev = expandedPosition;
//            notifyItemChanged(prev);
//        }
//        // Set the current position to "expanded"
//        expandedPosition = holder.getPosition();
//        notifyItemChanged(expandedPosition);
//    }
}
