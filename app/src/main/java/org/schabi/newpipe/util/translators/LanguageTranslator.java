package org.schabi.newpipe.util.translators;

import android.content.Context;

import java.util.Locale;

import static org.schabi.newpipe.util.Localization.getAppLocale;

/**
 * Created by B0pol on 2020-01-25.
 * LanguageTranslator.java is part of NewPipe.
 * <p>
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.     See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with NewPipe. If not, see <http://www.gnu.org/licenses/>.
 */

public final class LanguageTranslator {

    private LanguageTranslator() {
    }

    public static String getTranslatedLanguageName(final Locale loc, final Context c) {
        return loc == null ? "" : capitaliseFirstLetter(loc.getDisplayLanguage(getAppLocale(c)));
    }

    public static String getTranslatedLanguageName(final String languageCode, final Context c) {
        return getTranslatedLanguageName(new Locale(languageCode == null ? "" : languageCode), c);
    }

    public static String capitaliseFirstLetter(final String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
