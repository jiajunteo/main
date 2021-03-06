package seedu.thanepark.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.thanepark.commons.core.index.Index;
import seedu.thanepark.commons.util.StringUtil;
import seedu.thanepark.logic.parser.exceptions.ParseException;
import seedu.thanepark.model.ride.Maintenance;
import seedu.thanepark.model.ride.Name;
import seedu.thanepark.model.ride.WaitTime;
import seedu.thanepark.model.ride.Zone;
import seedu.thanepark.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_NAME_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String daysSinceMaintenanceString} into a {@code Maintenance}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code daysSinceMaintenanceString} is invalid.
     */
    public static Maintenance parseMaintenance(String daysSinceMaintenanceString) throws ParseException {
        requireNonNull(daysSinceMaintenanceString);
        String trimmedMaintenance = daysSinceMaintenanceString.trim();
        if (!Maintenance.isValidMaintenance(trimmedMaintenance)) {
            throw new ParseException(Maintenance.MESSAGE_MAINTENANCE_CONSTRAINTS);
        }
        return new Maintenance(trimmedMaintenance);
    }

    /**
     * Parses a {@code String thanepark} into an {@code Zone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code thanepark} is invalid.
     */
    public static Zone parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Zone.isValidZone(trimmedAddress)) {
            throw new ParseException(Zone.MESSAGE_ZONE_CONSTRAINTS);
        }
        return new Zone(trimmedAddress);
    }

    /**
     * Parses a {@code String waitingTime} into an {@code WaitTime}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code waitingTime} is invalid.
     */
    public static WaitTime parseWaitingTime(String waitingTime) throws ParseException {
        requireNonNull(waitingTime);
        String trimmedWaitingTime = waitingTime.trim();
        if (!WaitTime.isValidWaitTime(trimmedWaitingTime)) {
            throw new ParseException(WaitTime.MESSAGE_WAIT_TIME_CONSTRAINTS);
        }
        return new WaitTime(trimmedWaitingTime);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_TAG_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
