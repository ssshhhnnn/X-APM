package github.tornaco.xposedmoduletest.ui;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

import github.tornaco.xposedmoduletest.R;

/**
 * Created by guohao4 on 2017/10/24.
 * Email: Tornaco@163.com
 */

public enum Themes {

    DARK(R.string.theme_name_dark,
            R.color.dark,
            R.style.AppTheme,
            R.style.AppTheme_NoActionBar,
            R.style.AppTheme_Drawer_NoActionBar),

    BLACK(R.string.theme_name_black,
            R.color.black,
            R.style.AppThemeBlack,
            R.style.AppThemeBlack_NoActionBar,
            R.style.AppThemeBlack_Drawer_NoActionBar),

    PINK(R.string.theme_name_pink,
            R.color.pink,
            R.style.AppThemePink,
            R.style.AppThemePink_NoActionBar,
            R.style.AppThemePink_Drawer_NoActionBar),

    NEWYEAR(R.string.theme_name_newyear,
            R.color.red,
            R.style.AppThemeNEWYEAR,
            R.style.AppThemeNEWYEAR_NoActionBar,
            R.style.AppThemeNEWYEAR_Drawer_NoActionBar),

    O(R.string.theme_name_o,
            R.color.white,
            R.style.AppThemeO,
            R.style.AppThemeO_NoActionBar,
            R.style.AppThemeO_Drawer_NoActionBar),

    DEFAULT(R.string.theme_name_def,
            R.color.primary,
            R.style.AppThemeLight,
            R.style.AppThemeLight_NoActionBar,
            R.style.AppThemeLight_Drawer_NoActionBar);

    int themeStyleRes;
    int themeStyleResNoActionBar;
    int themeStyleResNoActionBarDrawer;
    @ColorRes
    int themeColor;

    @StringRes
    int themeName;

    Themes(int themeName, int themeColor, int themeStyleRes, int themeStyleResNoActionBar, int themeStyleResNoActionBarDrawer) {
        this.themeName = themeName;
        this.themeColor = themeColor;
        this.themeStyleRes = themeStyleRes;
        this.themeStyleResNoActionBar = themeStyleResNoActionBar;
        this.themeStyleResNoActionBarDrawer = themeStyleResNoActionBarDrawer;
    }

    public int getThemeStyleRes() {
        return themeStyleRes;
    }

    public int getThemeStyleResNoActionBar() {
        return themeStyleResNoActionBar;
    }

    public int getThemeStyleResNoActionBarDrawer() {
        return themeStyleResNoActionBarDrawer;
    }

    public int getThemeColor() {
        return themeColor;
    }

    public int getThemeName() {
        return themeName;
    }

    public static Themes valueOfChecked(String name) {
        for (Themes t : values()) {
            if (t.name().equals(name)) {
                return t;
            }
        }
        return DEFAULT;
    }

    public static List<String> getThemeNames(Context context) {
        List<String> names = new ArrayList<>(values().length);
        for (Themes t : values()) {
            names.add(context.getResources().getString(t.getThemeName()));
        }
        return names;
    }

    public static int indexOf(Themes themes) {
        return themes.ordinal();
    }

    public static Themes ofIndex(int index) {
        for (Themes t : values()) {
            if (t.ordinal() == index) return t;
        }
        return Themes.DEFAULT;
    }
}
