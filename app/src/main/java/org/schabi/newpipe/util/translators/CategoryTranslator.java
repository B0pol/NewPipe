package org.schabi.newpipe.util.translators;

import android.content.Context;

import org.schabi.newpipe.R;

/**
 * Created by B0pol on 2020-01-20.
 * CategoryTranslator.java is part of NewPipe.
 * <p>
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with NewPipe. If not, see <http://www.gnu.org/licenses/>.
 */

public final class CategoryTranslator {

    private CategoryTranslator() {
    }

    public static String getTranslatedCategoryName(
            final String categoryEnglishName, final Context c) {
        // Built from this: https://peertube.cpy.re/api/v1/videos/categories
        // but also youtube categories
        switch (categoryEnglishName.toLowerCase()) {
            case "music":
                return c.getString(R.string.category_title_music);
            case "films":
                return c.getString(R.string.category_title_films);
            case "vehicles":
                return c.getString(R.string.category_title_vehicles);
            case "art":
                return c.getString(R.string.category_title_art);
            case "sports":
                return c.getString(R.string.category_title_sports);
            case "travels":
                return c.getString(R.string.category_title_travels);
            case "gaming":
                return c.getString(R.string.category_title_gaming);
            case "people & blogs":
            case "people":
                return c.getString(R.string.category_title_people);
            case "comedy":
                return c.getString(R.string.category_title_comedy);
            case "entertainment":
                return c.getString(R.string.category_title_entertainment);
            case "news & politics":
                return c.getString(R.string.category_title_news_and_politics);
            case "how to":
                return c.getString(R.string.category_title_how_to);
            case "education":
                return c.getString(R.string.category_title_education);
            case "activism":
                return c.getString(R.string.category_title_activism);
            case "science & technology":
                return c.getString(R.string.category_title_science_and_technology);
            case "animals":
                return c.getString(R.string.category_title_animals);
            case "kids":
                return c.getString(R.string.category_title_kids);
            case "food":
                return c.getString(R.string.category_title_food);
            case "misc":
                return c.getString(R.string.category_title_misc);
            default:
                return categoryEnglishName;
        }

    }

}
