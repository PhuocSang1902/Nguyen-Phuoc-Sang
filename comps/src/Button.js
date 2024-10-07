import className from 'classnames';
function Button({
  children,
  primary,
  secondary,
  success,
  warning,
  danger,
  outline,
  rounded,
}) {
  let classes = className('px-3', 'py-1.5', 'border', {
    'border-blue-600 bg-blue-500 text-white': primary,
    'border-gray-900 bg-gray-900 text-white': secondary,
    'border-green-600 bg-green-500 text-white': success,
    'border-yellow-400 bg-yellow-400 text-white': warning,
    'border-red-600 bg-red-500 text-white': danger,
  });

  return (
    <button className={classes}>
      {children}
    </button>
  );
}
Button.propTypes = {
  checkVariationValue: ({ primary, secondary, success, warning, danger }) => {
    const count =
      Number(!!primary) +
      Number(!!secondary) +
      Number(!!success) +
      Number(!!warning) +
      Number(!!danger);

    if (count > 1) {
      return new Error(
        'Only one of primary, secondary, success, warning, danger can be true'
      );
    }
  },
};

export default Button;
