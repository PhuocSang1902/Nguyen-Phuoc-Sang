import Accordion from '../components/Accordion';

function AccordionPage() {
  const items = [
    {
      id: 'fds',
      label: 'Can I use React on a project?',
      content:
        'You can user React on any Project you want. You can user React on any Project you want. You can user React on any Project you want. You can user React on any Project you want.',
    },
    {
      id: 'fdfdafs',
      label: 'Can I use Javascript on a project',
      content:
        'You can user React on any Project you want. You can user React on any Project you want. You can user React on any Project you want. You can user React on any Project you want.',
    },
    {
      id: 'sdfasd',
      label: 'Can I use CSS on a project',
      content:
        'You can user React on any Project you want. You can user React on any Project you want. You can user React on any Project you want. You can user React on any Project you want.',
    },
  ];

  return <Accordion items={items} />;
}

export default AccordionPage;
