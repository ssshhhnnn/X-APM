package github.tornaco.xposedmoduletest.ui.adapter.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;

import github.tornaco.xposedmoduletest.R;
import github.tornaco.xposedmoduletest.model.CommonPackageInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by guohao4 on 2017/12/18.
 * Email: Tornaco@163.com
 */

public class CommonPackageInfoViewerAdapter extends CommonPackageInfoAdapter {

    private int mDefaultTextColor;

    @Getter
    @Setter
    private AdapterView.OnItemClickListener onItemClickListener;

    public CommonPackageInfoViewerAdapter(Context context) {
        super(context);
        setChoiceMode(true);

        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.torListItemTitleTextColor, typedValue, true);
        int resId = typedValue.resourceId;

        this.mDefaultTextColor = ContextCompat.getColor(context, resId);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final CommonViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        final CommonPackageInfo packageInfo = commonPackageInfos.get(position);
        boolean disabled = packageInfo.isDisabled();
        if (disabled) {
            holder.getLineOneTextView().setText(packageInfo.getAppName() + "\t*已冻结*");
            holder.getLineOneTextView().setTextColor(Color.RED);
        } else {
            holder.getLineOneTextView().setText(packageInfo.getAppName());
            holder.getLineOneTextView().setTextColor(mDefaultTextColor);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClick(null, v, holder.getAdapterPosition(), holder.getItemId());
                }
            }
        });
    }


}
